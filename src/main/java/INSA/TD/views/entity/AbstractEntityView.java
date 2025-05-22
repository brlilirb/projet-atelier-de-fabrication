package INSA.TD.views.entity;

import INSA.TD.models.AbstractIdentity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final TableView<T> tableView = new TableView<>();

    protected AbstractEntityView() {
        super();
        setSpacing(DEFAULT_SPACING);
        setPadding(new Insets(DEFAULT_SPACING));

        getChildren().add(tableView);

        tableView.setItems(getData());

        initTableColumn();
    }

    @SuppressWarnings("unchecked")
    protected void initTableColumn() {
        TableColumn<T, String> referenceColumn = new TableColumn<>("Référence");
        referenceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        referenceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        referenceColumn.setOnEditCommit(event -> {
            event.getRowValue().setId(event.getNewValue());
        });
        getTableView().getColumns().addAll(referenceColumn);

        initSpecificTableColumns();
    }

    public void initListener() {
        /*getData().addListener((ListChangeListener<T>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    ajouter(change.getAddedSubList().getFirst());
                } else if (change.wasRemoved()) {
                    supprimer(change.getRemoved().getFirst().getId());
                }
            }
        });*/
        getData().addListener((ListChangeListener<T>) change -> {
            while (change.next()) {
                if (change.wasUpdated()) {
                    int from = change.getFrom();
                    int to = change.getTo(); // Usually to = from + 1 for single updates

                    for (int i = from; i < to; i++) {
                        modifier(getData().get(i));
                    }
                }
            }
        });

    }

    public TableView<T> getTableView() {
        return tableView;
    }

    protected abstract void initSpecificTableColumns();
}
