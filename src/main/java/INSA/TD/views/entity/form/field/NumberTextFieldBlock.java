package INSA.TD.views.entity.form.field;

import INSA.TD.views.entity.form.field.textfield.NumberTextField;
import INSA.TD.views.label.TitleLabel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class NumberTextFieldBlock extends VBox {

    private Label label;
    private NumberTextField textField;

    public NumberTextFieldBlock(String label) {
        this.label = new TitleLabel(label);
        textField = new NumberTextField(label);
        getChildren().addAll(
                this.label,
                textField
        );
    }

    public Label getLabel() {
        return label;
    }

    public NumberTextField getTextField() {
        return textField;
    }

    public Number getValue() {
        return getTextField().getNumberTextFormatter()
                .getValue();
    }

    public float getFloatValue() {
        return Objects.nonNull(getValue()) ? getValue().floatValue() : 0;
    }
}
