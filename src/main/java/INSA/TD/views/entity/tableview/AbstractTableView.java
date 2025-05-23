package INSA.TD.views.entity.tableview;

import INSA.TD.models.AbstractIdentity;
import javafx.collections.ObservableList;
import javafx.scene.CacheHint;
import javafx.scene.control.TableView;

public abstract class AbstractTableView<T extends AbstractIdentity> extends TableView<T> {

    protected AbstractTableView(ObservableList<T> data) {
        setMaxHeight(500);
        setCache(true);
        setCacheHint(CacheHint.SCALE);
        initTableColumn();
        setItems(data);
    }

    protected abstract void initTableColumn();
}
