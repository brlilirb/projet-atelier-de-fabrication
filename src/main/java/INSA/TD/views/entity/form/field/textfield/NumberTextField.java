package INSA.TD.views.entity.form.field.textfield;

import INSA.TD.views.entity.factory.TextFormatterFactory;
import javafx.scene.control.TextFormatter;

public class NumberTextField extends CustomTextField {

    public NumberTextField(String label) {
        super(label);
        setTextFormatter(TextFormatterFactory.getNumberTextFormatter());
    }

    @SuppressWarnings("unchecked")
    public TextFormatter<Number> getNumberTextFormatter() {
        return (TextFormatter<Number>) getTextFormatter();
    }
}
