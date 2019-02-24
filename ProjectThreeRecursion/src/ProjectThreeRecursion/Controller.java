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

    public void compute(ActionEvent actionEvent) {

        Sequence.resetEfficiency();

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
    }
}
