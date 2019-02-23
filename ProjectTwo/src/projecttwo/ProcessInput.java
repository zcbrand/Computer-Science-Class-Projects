/* Filename: ProcessInput.java
 * Author: Zachary Brandenburg
 * Date: 10 February 2019
 * Purpose: Helper class to help process input and catch Exceptions
 */
package projecttwo;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static java.lang.Double.isNaN;
import static java.lang.Double.parseDouble;

class ProcessInput {

    static void deposit(Account activeAccount, Stage stage, TextField textField) {
        try {
            activeAccount.deposit(getInputFromField(textField.getText()), stage);
        } catch (NumberFormatException ex) {
            popupDialog("Input is not a valid number", stage);
        }
    }

    static void withdraw(Account activeAccount, Stage stage, TextField textField) {
        try {
            activeAccount.withdraw(getInputFromField(textField.getText()), stage);
        } catch (InsufficientFundsException ex) {
            popupDialog("Insufficient funds in Account", stage);
        } catch (NumberFormatException ex) {
            popupDialog("Input is not a valid number", stage);
        }
    } // end withdraw()

    static void transferTo(Account activeAccount, Account inactiveAccount, Stage stage, TextField textField) {
        try {
            activeAccount.transferTo(getInputFromField(textField.getText()), inactiveAccount, stage);
        } catch (InsufficientFundsException ex) {
            popupDialog("Insufficient funds in Account", stage);
        } catch (NumberFormatException ex) {
            popupDialog("Input is not a valid number", stage);
        }
    } // end transferTo()

    static double getInputFromField(String input) throws NumberFormatException {

        if(isNaN(parseDouble(input)) || parseDouble(input) < 0) {
            throw new NumberFormatException("Is not a number");
        }
        return parseDouble(input);
    } // end of getInput()

    // Popup dialog box to display important information to the user
    static void popupDialog(String message, Stage stage) {

        final Stage popUpStage = new Stage();

        // Initialize Label
        Label popUpMessage = new Label(message);
        popUpMessage.setWrapText(true);
        popUpMessage.setFont(new Font(20));

        BorderPane root = new BorderPane();
        root.setCenter(popUpMessage);

        Scene scene = new Scene(root, 200, 150);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initOwner(stage);
        popUpStage.setScene(scene);
        popUpStage.show();
    } // end of popupDialog()

}
