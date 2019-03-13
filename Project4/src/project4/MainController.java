/* Filename: MainController.java
 * Author: Zachary Brandenburg
 * Date: 10 March 2019
 * Purpose: Provide control to UI elements
 */
package project4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.*;


public class MainController {
    //Initialize lists to use in updateStudentRecord method
    private final List<Integer> CREDIT_VALUES = new ArrayList<>(Arrays.asList(3, 6));
    private final List<String> GRADES = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "F"));

    public ComboBox selectionComboBox;
    public TextField idTextField;
    public TextField nameTextField;
    public TextField majorTextField;

    //Method containing switch statement to process user request
    public void processRequestButton(ActionEvent actionEvent) {

        switch ((String) selectionComboBox.getValue()) {
            case "Insert":
                insertStudentRecord();
                break;
            case "Delete":
                deleteStudentRecord();
                break;
            case "Find":
                findStudentRecord();
                break;
            case "Update":
                updateStudentRecord();
                break;
            default: // Default value set unused
                break;
        } // end switch
    } // end processRequestButton()

    private void insertStudentRecord() {
        /* Check if studentId key exists in studentDatabase
         * if present alert user that student already exists
         * if not present take data from ui field and create a new student record
         */
        if (idTextField.getText().equals("") || nameTextField.getText().equals("")) {
            alertPopUp("Please enter an ID and Name", Alert.AlertType.INFORMATION);
        } else if (Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("StudentID already exists!", Alert.AlertType.INFORMATION);
        else {
            Main.studentDatabase.put(idTextField.getText(),
                    new Student(nameTextField.getText(),
                            majorTextField.getText()));
            if (Main.studentDatabase.containsKey(idTextField.getText()))
                alertPopUp("New Student added with ID: " + idTextField.getText(),
                        Alert.AlertType.INFORMATION);
            else {
                alertPopUp("Failed to add Student with ID: " + idTextField.getText(),
                        Alert.AlertType.WARNING);
            }
        } // end if/else
    } // end insertStudentRecord()

    private void deleteStudentRecord() {
        /* Check if studentId key exists in studentDatabase
         * if present alert user that student already exists
         * if not present take data from ui field and create a new student record
         */
        if (idTextField.getText().equals("")) {
            alertPopUp("Please enter an ID and Name", Alert.AlertType.INFORMATION);
        } else if (!Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("Student does not exist!", Alert.AlertType.INFORMATION);
        else {
            Main.studentDatabase.remove(idTextField.getText());
            if (!Main.studentDatabase.containsKey(idTextField.getText()))
                alertPopUp("Deleted Student with ID: " + idTextField.getText(),
                        Alert.AlertType.INFORMATION);
            else {
                alertPopUp("Failed to delete Student with ID: " + idTextField.getText(),
                        Alert.AlertType.WARNING);
            }
        } // end if/else
    } // end deleteStudentRecord()

    private void findStudentRecord() {
        /* Check if studentId key exists in studentDatabase
         * if present alert user that student already exists
         * if not present take data from ui field and create a new student record
         */
        if (idTextField.getText().equals("")) {
            alertPopUp("Please enter an ID and Name", Alert.AlertType.INFORMATION);
        } else if (!Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("Student does not exist!", Alert.AlertType.WARNING);
        else {
            alertPopUp(Main.studentDatabase.get(idTextField.getText()).toString(),
                    Alert.AlertType.INFORMATION);
        } // end if/else
    } // end findStudentRecord()

    private void updateStudentRecord() {
        /* Check if studentId key exists in studentDatabase
         * if present alert user that student already exists
         * if not present take data from ui field and create a new student record
         */
        if (idTextField.getText().equals("")) {
            alertPopUp("Please enter an ID and Name", Alert.AlertType.INFORMATION);
        } else if (!Main.studentDatabase.containsKey(idTextField.getText()))
            alertPopUp("Student does not exist!", Alert.AlertType.WARNING);
        else {
            double grade = letterGradeToQuality(
                    choiceDialogPopUp(GRADES, "Choose grade:", "A"));
            int credits = choiceDialogPopUp(CREDIT_VALUES, "Choose credits:", 3);

            Main.studentDatabase.get(idTextField.getText())
                    .courseCompleted(credits, grade);
        } // end if/else
    } // end updateStudentRecord()

    // Converts a letter grade to a quality used in GPA calculation
    private double letterGradeToQuality(String letterGrade) {
        double gradeQuality = 0.0;

        switch (letterGrade) {
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
                alertPopUp("Please select a letter grade!", Alert.AlertType.INFORMATION);
                break;
        } // end switch
        return gradeQuality;
    } // end letterGradeToQuality()

    /*
     * Generic method that spawns a popup using a collection and returns the result
     */
    private <T> T choiceDialogPopUp(Collection<T> collection, String contentText, T defaultValue) {
        ChoiceDialog<T> dialog = new ChoiceDialog<>(defaultValue, collection);
        dialog.setContentText(contentText);

        Optional<T> result = dialog.showAndWait();

        return result.get();
    } // end choiceDialogPopUp()

    // Used to alert the user of various conditions
    private void alertPopUp(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, message);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> alert.close());
    } // end alertPopUp()
} // end MainController()
