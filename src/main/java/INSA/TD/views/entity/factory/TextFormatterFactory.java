package INSA.TD.views.entity.factory;

import javafx.scene.control.TextFormatter;
import javafx.util.converter.NumberStringConverter;

public class TextFormatterFactory {

    private TextFormatterFactory() {
    }

    public static TextFormatter<Number> getNumberTextFormatter() {
        return new TextFormatter<>(new NumberStringConverter());
    }
}
