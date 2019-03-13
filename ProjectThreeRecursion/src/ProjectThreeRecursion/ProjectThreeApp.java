/* Filename: ProjectThreeApp.java
 * Author: Zachary Brandenburg
 * Date: 23 February 2019
 * Purpose: This program calculates  the terms of the
 * following sequence of numbers: 0 1 2 5 12 29 ... where each term of the sequence is twice
 * the previous term plus the second previous term. The 0th term of the sequence is 0 and the
 * 1st term of the sequence is 1. Once computed the the program displays the n term in the sequence and the method
 * selected to compute the results efficiency.
 */

package ProjectThreeRecursion;

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

    /* Used when closing the program to calculate the efficiency of the iterative and recursive methods
     * the write those results to a file
     */
    public void efficiencyDataToFile() {
        // Declare method variables
        int iterativeEfficiency;
        int recursiveEfficiency;

        try (FileWriter outputData = new FileWriter("EfficiencyData.csv")) {
            // Build file header
            outputData.append("N,Iterative,Recursive,\n");

            /* loop from n = 0-10, e
             * each iteration resets the efficiency then get efficiency data for
             * n of both iterative and recursive methods and writes the results to a file
             */
            for (int i = 0; i <= 10; i++) {

                Sequence.resetEfficiency();
                Sequence.computeIterative(i);
                iterativeEfficiency = Sequence.getEfficiency();
                Sequence.resetEfficiency();
                Sequence.computeRecursive(i);
                recursiveEfficiency = Sequence.getEfficiency();

                // Write to file i,iterativeEfficiency,recursiveEfficiency then next line
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
