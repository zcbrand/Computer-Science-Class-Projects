package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static java.lang.Double.parseDouble;

public class Pythagoras extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label message = new Label(" ");
        message.setAlignment(Pos.CENTER);
        message.setFont(new Font(30));
        Label sideALabel = new Label("Side A: ");
        sideALabel.setAlignment(Pos.CENTER_RIGHT);
        Label sideBLabel = new Label("Side B: ");
        sideBLabel.setAlignment(Pos.CENTER_RIGHT);


        TextField sideA = new TextField("Side A");
        sideA.setMaxWidth(100);
        TextField sideB = new TextField("Side B");
        sideB.setMaxWidth(100);

        HBox textFieldBar = new HBox(20, sideALabel, sideA, sideBLabel, sideB);
        textFieldBar.setAlignment(Pos.CENTER);

        Button findHypotenuseButton = new Button("Get Hypotenuse");
        findHypotenuseButton.setOnAction(e -> getSideC(parseDouble(sideA.getText()),
                parseDouble(sideB.getText()),
                message));

        // Set up root pane
        VBox root = new VBox(10, textFieldBar, findHypotenuseButton, message);
        root.setAlignment(Pos.CENTER);


        // Set up and show scene
        Scene scene = new Scene(root, 450, 200);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pythagoras Theorem");
        primaryStage.show();
    }

    public void getSideC(double sideA, double sideB, Label message) {
        message.setText("Hypotenuse: " + Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2)));
    }
}
