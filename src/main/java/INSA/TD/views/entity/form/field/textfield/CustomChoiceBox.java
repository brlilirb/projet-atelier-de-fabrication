package INSA.TD.views.entity.form.field.textfield;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

public class CustomChoiceBox<T> extends ChoiceBox<T> {

    public CustomChoiceBox(ObservableList<T> items,
                           T defaultValue,
                           StringConverter<T> converter) {
        super(items);
        setValue(defaultValue);
        setConverter(converter);
    }
}
