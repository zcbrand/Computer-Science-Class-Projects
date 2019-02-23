package ProjectThree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileWriter;
import java.io.IOException;

public class ProjectThreeApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void efficiencyDataToFile() {
        int iterativeEfficiency;
        int recursiveEfficiency;

        try (FileWriter outputData = new FileWriter("EfficiencyData.csv")) {
            // Build file header
            outputData.append("N,Iterative,Recursive,\n");

            for (int i = 0; i <= 10; i++) {
                Sequence.computeIterative(i);
                iterativeEfficiency = Sequence.getEfficiency();
                Sequence.resetEfficiency();
                Sequence.computeRecursive(i);
                recursiveEfficiency = Sequence.getEfficiency();
                Sequence.resetEfficiency();
                outputData.append(String.valueOf(i))
                        .append(",")
                        .append(String.valueOf(iterativeEfficiency))
                        .append(",")
                        .append(String.valueOf(recursiveEfficiency))
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ProjectThreeUI.fxml"));
        primaryStage.setTitle("Project Three");
        primaryStage.setScene(new Scene(root, 300, 275));
        // Override the event handler when the application closes to make a csv file that contains efficiency data
        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            efficiencyDataToFile();
        });
        primaryStage.show();
    }
}
