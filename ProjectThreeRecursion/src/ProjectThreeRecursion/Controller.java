/* Filename: Controller.java
 * Author: Zachary Brandenburg
 * Date: 23 February 2019
 * Purpose: Controller class for the UI
 */

package ProjectThreeRecursion;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class Controller {
    public ToggleGroup computeTypeGroup;
    public RadioButton iterativeRadio;
    public RadioButton recursiveRadio;
    public TextField nValue;
    public TextField result;
    public TextField efficiency;

    // Tells what method to use while computing entered N value
    public void compute(ActionEvent actionEvent) {

        Sequence.resetEfficiency();
        try {
            if (iterativeRadio.isSelected()) {
                result.setText(String
                        .valueOf(Sequence
                                .computeIterative(Integer
                                        .parseInt(nValue.getText()))));
            } else {
                result.setText(String
                        .valueOf(Sequence
                                .computeRecursive(Integer
                                        .parseInt(nValue.getText()))));
            }

            efficiency.setText(String
                    .valueOf(Sequence
                            .getEfficiency()));
        } catch (NumberFormatException e) {
            System.out.println("Input is not a Number");
        }
    }
}
