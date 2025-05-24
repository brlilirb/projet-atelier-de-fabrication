package INSA.TD.views.entity.form.field;

import INSA.TD.views.entity.form.field.textfield.CustomTimePicker;
import INSA.TD.views.label.TitleLabel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TimePickerBlock extends VBox {

    private final Label label;
    private final CustomTimePicker timePicker;

    public TimePickerBlock(String label) {
        this.label = new TitleLabel(label);
        timePicker = new CustomTimePicker();
        getChildren().addAll(
                this.label,
                timePicker
        );
    }

    public Label getLabel() {
        return label;
    }

    public CustomTimePicker getTimePicker() {
        return timePicker;
    }

    public String getTime() {
        return getTimePicker().getValue();
    }
}
