package INSA.TD.views.entity.form.field.textfield;

import INSA.TD.utils.StringConverterUtils;
import javafx.scene.control.DatePicker;

public class CustomDatePicker extends DatePicker {

    public CustomDatePicker() {
        setConverter(StringConverterUtils.toLocalDateStringConverter());
    }
}
