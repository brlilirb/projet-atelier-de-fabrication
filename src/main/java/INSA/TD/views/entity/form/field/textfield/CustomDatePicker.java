package INSA.TD.views.entity.form.field.textfield;

import INSA.TD.utils.StringConverterUtils;
import javafx.scene.control.DatePicker;

public class CustomDatePicker extends DatePicker {

    public CustomDatePicker() {
        getEditor().setDisable(true);
        getEditor().setStyle("-fx-opacity: 1; -fx-text-fill: black; -fx-control-inner-background: white;");
        setConverter(StringConverterUtils.toLocalDateStringConverter());
    }
}
