package INSA.TD.views.entity.form.field;

import INSA.TD.utils.ConstantesUtils;
import INSA.TD.views.entity.form.field.textfield.CustomDatePicker;
import INSA.TD.views.label.TitleLabel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DatePickerBlock extends VBox {

    private final Label label;
    private final CustomDatePicker datePicker;

    public DatePickerBlock(String label) {
        this.label = new TitleLabel(label);
        datePicker = new CustomDatePicker();
        getChildren().addAll(
                this.label,
                datePicker
        );
    }

    public Label getLabel() {
        return label;
    }

    public CustomDatePicker getDatePicker() {
        return datePicker;
    }

    public String getDate() {
        return getDatePicker().getValue()
                .format(ConstantesUtils.DATE_FORMATTER);
    }
}
