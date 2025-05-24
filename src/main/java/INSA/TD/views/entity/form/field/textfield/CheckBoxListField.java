package INSA.TD.views.entity.form.field.textfield;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.Map;

public class CheckBoxListField<T> extends ListView<T> {

    private final Map<T, BooleanProperty> selectedMap = new HashMap<>();

    public CheckBoxListField(ObservableList<T> items, StringConverter<T> converter) {
        super(items);
        initSelectedMap(items);
        setCellFactory(CheckBoxListCell.forListView(
                selectedMap::get,
                converter
        ));
    }

    public Map<T, BooleanProperty> getSelectedMap() {
        return selectedMap;
    }

    public ObservableList<T> getSelectedItems() {
        return getItems().filtered(p -> selectedMap.get(p).get());
    }

    private void initSelectedMap(ObservableList<T> items) {
        items.forEach(p -> selectedMap.put(p, new SimpleBooleanProperty(false)));
    }
}
