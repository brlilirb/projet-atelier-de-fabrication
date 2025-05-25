package INSA.TD.views.entity.form.field.textfield;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

public class CustomChoiceBox<T> extends ComboBox<T> {

    public CustomChoiceBox(ObservableList<T> items) {
        super(items);
    }

    public CustomChoiceBox(ObservableList<T> items,
                           StringConverter<T> converter) {
        super(items);
        setConverter(converter);
    }

    public CustomChoiceBox(ObservableList<T> items,
                           T defaultValue,
                           StringConverter<T> converter) {
        super(items);
        setValue(defaultValue);
        setConverter(converter);
    }
}
