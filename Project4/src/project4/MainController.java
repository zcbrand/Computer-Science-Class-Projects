package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.*;


public class MainController {
    private final List<Integer> CREDIT = Arrays.asList(3, 6);
    private final List<String> GRADES = Arrays.asList("A", "B", "C", "D", "E");

    public ComboBox<String> selectionComboBox;
    public TextField idTextField;
    public TextField nameTextField;
    public TextField majorTextField;

    public void processRequestButton(ActionEvent actionEvent) {

        switch (selectionComboBox.getValue()) {
            case "Insert":
                insert();
                break;
            case "Delete":
                delete();
                break;
            case "Find":
                find();
                break;
            case "Update":
                update();
                break;
            default:
                alertPopUp("Please select an option!", Alert.AlertType.INFORMATION);
                break;
        }
    }

    private void insert() {
        if (Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("StudentID already exists!", Alert.AlertType.INFORMATION);
        else {
            Main.studentDatabase.put(idTextField.getText(),
                    new Student(nameTextField.getText(),
                            majorTextField.getText()));
        }
    }

    private void delete() {
        if (!Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("Student does not exist!", Alert.AlertType.INFORMATION);
        else {
            Main.studentDatabase.remove(idTextField.getText());
        }
    }

    private void find() {
        if (!Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("Student does not exist!", Alert.AlertType.WARNING);
        else {
            alertPopUp(Main.studentDatabase.get(idTextField.getText()).toString(),
                    Alert.AlertType.INFORMATION);
        }
    }

    private void update() {
        

        if (!Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("Student does not exist!", Alert.AlertType.WARNING);
        else {
            double grade = gradeConverter(updatePopUp(GRADES, "Choose grade:", "A"));
            int credits = updatePopUp(CREDIT, "Choose credits:", 3);

            Main.studentDatabase.get(idTextField.getText())
                    .courseCompleted(credits, grade);
        }
    }

    private double gradeConverter(String grade) {
        Double gradeQuality;

        switch (grade) {
            case "A":
                gradeQuality = 4.0;
                break;
            case "B":
                gradeQuality = 3.0;
                break;
            case "C":
                gradeQuality = 2.0;
                break;
            case "D":
                gradeQuality = 1.0;
                break;
            case "F":
                gradeQuality = 0.0;
                break;
            default:
                gradeQuality = 0.0;
        }
        return gradeQuality;
    }

    private <T> T updatePopUp(Collection<T> collection, String contentText, T defaultValue) {
        ChoiceDialog<T> dialog = new ChoiceDialog<>(defaultValue, collection);
        dialog.setContentText(contentText);

        Optional<T> result = dialog.showAndWait();

        return result.get();
    }

    private void alertPopUp(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, message);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> alert.close());
    }

}
