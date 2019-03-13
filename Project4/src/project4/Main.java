/* Filename: Main.java
 * Author: Zachary Brandenburg
 * Date: 10 March 2019
 * Purpose: This program manages a student database.
 */
package project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Main extends Application {
    /* Static HashMap that holds student id student key value pair
     * set to an initial capacity opf 10
     */
    public static HashMap<String, Student> studentDatabase = new HashMap<>(10);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
            primaryStage.setTitle("Student Records");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
