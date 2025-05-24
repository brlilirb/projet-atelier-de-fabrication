package INSA.TD.views.entity.tableview;

import INSA.TD.models.AbstractIdentity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public abstract class AbstractEntityTableView<T extends AbstractIdentity> extends AbstractTableView<T> {

    protected AbstractEntityTableView(ObservableList<T> data) {
        super(data);
    }

    @SuppressWarnings("unchecked")
    protected void initTableColumn() {
        TableColumn<T, String> referenceColumn = new TableColumn<>("Référence");
        referenceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        getColumns().addAll(referenceColumn);

        initSpecificTableColumns();
    }

    protected abstract void initSpecificTableColumns();
}
