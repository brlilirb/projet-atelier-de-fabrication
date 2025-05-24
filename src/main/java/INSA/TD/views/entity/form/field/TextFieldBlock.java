package INSA.TD.views.entity.form.field;

import INSA.TD.views.entity.form.field.textfield.CustomTextField;
import INSA.TD.views.label.TitleLabel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class TextFieldBlock extends VBox {

    private Label label;
    private CustomTextField textField;

    public TextFieldBlock(String label) {
        this.label = new TitleLabel(label);
        textField = new CustomTextField(label);
        getChildren().addAll(
                this.label,
                textField
        );
    }

    public Label getLabel() {
        return label;
    }

    public CustomTextField getTextField() {
        return textField;
    }

    public String getText() {
        return getTextField().getText();
    }
}
