/* Filename: ProjectTwoBankATM.java
 * Author: Zachary Brandenburg
 * Date: 10 February 2019
 * Purpose: Builds the GUI for an ATM machine in JavaFX
 */
package projecttwo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProjectTwoBankATMApp extends Application {

    private Account savings = new Account(20.00, "My Savings");
    private Account checking = new Account(100.00, "My Checking");
    private Account activeAccount = checking; // Default active account
    private Account inactiveAccount = savings; // Default inactive account

    public static void main(String[] args) {
        launch(args);  // Run this Application.
    } // end of main


    public void start(Stage stage) {

        // Styles for buttons
        String buttonStyles = "-fx-background-color: #e28a41;";

        // Initialize Label
        Label message = new Label("Welcome to\nProject Two Bank");
        message.setWrapText(true);
        message.setFont(new Font(30));

        // Initialize TextField
        TextField inputField = new TextField("0.00");
        inputField.setMaxWidth(100);

        // Initialize Buttons
        Button depositButton = new Button("Deposit");
        depositButton.setMaxWidth(76);
        depositButton.setStyle(buttonStyles);
        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setMaxWidth(76);
        withdrawButton.setStyle(buttonStyles);
        Button transferToButton = new Button("Transfer To");
        transferToButton.setMaxWidth(76);
        transferToButton.setStyle(buttonStyles);
        Button balanceButton = new Button("Balance");
        balanceButton.setMaxWidth(76);
        balanceButton.setStyle(buttonStyles);

        // Initialize Radio Buttons
        RadioButton checkingRadioButton = new RadioButton("Checking");
        checkingRadioButton.setTextFill(Color.WHITE);
        checkingRadioButton.setUserData(checking);
        RadioButton savingsRadioButton = new RadioButton("Savings");
        savingsRadioButton.setTextFill(Color.WHITE);
        savingsRadioButton.setUserData(savings);

        // Set default selected radio button to checking
        checkingRadioButton.setSelected(true);

        // Define ToggleGroup and assign RadioButtons
        ToggleGroup accountGroup = new ToggleGroup();
        checkingRadioButton.setToggleGroup(accountGroup);
        savingsRadioButton.setToggleGroup(accountGroup);

        // Create HBox for radio buttons
        HBox radioButtonBar = new HBox(20, checkingRadioButton, savingsRadioButton);
        radioButtonBar.setMaxSize(450, 50);
        radioButtonBar.setPadding(new Insets(15, 12, 15, 12));
        radioButtonBar.setAlignment(Pos.CENTER_LEFT);
        radioButtonBar.setStyle("-fx-background-color: #333333");

        // Create VBox for selection buttons
        VBox accountControlBox = new VBox(10, depositButton, withdrawButton, transferToButton, balanceButton);
        accountControlBox.setMaxWidth(100);
        accountControlBox.setMinHeight(150);
        accountControlBox.setPadding(new Insets(15, 10, 15, 10));
        accountControlBox.setAlignment(Pos.TOP_LEFT);
        accountControlBox.setStyle("-fx-background-color: #444444");

        // Create VBox for Input and Output
        VBox inputOutputBox = new VBox(message, inputField);
        inputOutputBox.setMaxWidth(350);
        inputOutputBox.setPadding(new Insets(15, 12, 15, 12));

        /* Establish an event listener for the accountGroup ToggleGroup that assigns the selected radio to activeAccount
         * then makes the inactiveAccount the opposite account */
        accountGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            activeAccount = (Account) accountGroup.getSelectedToggle().getUserData();
            if (inactiveAccount == activeAccount && inactiveAccount == savings) {
                inactiveAccount = checking;
            } else inactiveAccount = savings;
        }); // end toggle event listener

        // Button Actions uses static class ProcessInput to well...process textField input.
        depositButton.setOnAction(e -> ProcessInput.deposit(activeAccount, stage, inputField));
        withdrawButton.setOnAction(e -> ProcessInput.withdraw(activeAccount, stage, inputField));
        transferToButton.setOnAction(e -> ProcessInput.transferTo(activeAccount, inactiveAccount, stage, inputField));
        balanceButton.setOnAction(e -> message.setText(activeAccount.balance()));

        // Set up root pane
        BorderPane root = new BorderPane();
        root.setTop(radioButtonBar);
        root.setLeft(accountControlBox);
        root.setCenter(inputOutputBox);

        // Set up and show scene
        Scene scene = new Scene(root, 450, 200);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Project Two Bank");
        stage.show();

    } // end start();

} // end class ProjectTwoBankATMApp