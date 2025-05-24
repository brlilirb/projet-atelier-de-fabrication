package INSA.TD.views.entity.form.field;

import INSA.TD.views.entity.form.field.textfield.CheckBoxListField;
import INSA.TD.views.label.TitleLabel;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class CheckBoxListBlock<T> extends VBox {

    private final Label label;
    private final CheckBoxListField<T> checkBoxListField;

    public CheckBoxListBlock(String label,
                             ObservableList<T> items,
                             StringConverter<T> converter) {
        this.label = new TitleLabel(label);
        checkBoxListField = new CheckBoxListField<>(items, converter);
        getChildren().addAll(
                this.label,
                checkBoxListField
        );
    }

    public Label getLabel() {
        return label;
    }

    public CheckBoxListField<T> getCheckBoxListField() {
        return checkBoxListField;
    }

    public ObservableList<T> getSelectedItems() {
        return getCheckBoxListField().getSelectedItems();
    }

    public void setSelectedItems(ObservableList<T> items) {
        getCheckBoxListField().setItems(items);
    }
}
