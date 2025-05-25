package INSA.TD.views.entity.factory;

import INSA.TD.models.Fiabilite;
import javafx.scene.control.TableCell;
import javafx.util.StringConverter;

import static INSA.TD.utils.ConstantesUtils.NUMBER_FORMAT;
import static INSA.TD.utils.StringConverterUtils.toFiabiliteStringConverter;

public class TableCellFactory {

    private TableCellFactory() {
    }

    public static <T> TableCell<T, Number> getCurrencyCell() {
        return new TableCell<>() {
            @Override
            protected void updateItem(Number value, boolean empty) {
                super.updateItem(value, empty);
                if (empty || value == null) {
                    setText(null);
                } else {
                    setText(NUMBER_FORMAT.format(value));
                }
            }
        };
    }

    public static <T> TableCell<T, Fiabilite> getFiabiliteCell() {
        StringConverter<Fiabilite> converter = toFiabiliteStringConverter();
        return new TableCell<>() {
            @Override
            protected void updateItem(Fiabilite value, boolean empty) {
                super.updateItem(value, empty);
                if (empty || value == null) {
                    setText(null);
                } else {
                    setText(converter.toString(value));
                }
            }
        };
    }
}
