package INSA.TD.views.entity.tableview;

import INSA.TD.models.AbstractIdentity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public abstract class AbstractTableView<T extends AbstractIdentity> extends TableView<T> {

    protected AbstractTableView(ObservableList<T> data) {
        setMaxHeight(500);
        initTableColumn();
        setItems(data);
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
