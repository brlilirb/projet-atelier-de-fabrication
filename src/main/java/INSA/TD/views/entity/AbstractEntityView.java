package INSA.TD.views.entity;

import INSA.TD.models.AbstractIdentity;
import INSA.TD.views.button.DeleteButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final TableView<T> tableView = new TableView<>();
    private final Button deleteButton = new DeleteButton();

    protected AbstractEntityView() {
        super();
        setSpacing(DEFAULT_SPACING);
        setPadding(new Insets(DEFAULT_SPACING));

        getChildren().addAll(tableView, deleteButton);

        tableView.setItems(getData());

        initTableColumn();

        initDeleteButton();
    }

    private void initDeleteButton() {
        deleteButton.setVisible(false); //TODO ne pas afficher pour ouvrier
        tableView.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> deleteButton.setVisible(newValue != null));
        deleteButton.setOnAction(_ -> {
            ObservableList<T> selectedItems = tableView.getSelectionModel().getSelectedItems();
            for (T selected : selectedItems) {
                if (selected != null) {
                    getController().supprimer(selected.getId());
                }
            }
            getData().removeAll(selectedItems); // Supprimer l'objet sélectionné de la liste
            tableView.getSelectionModel().clearSelection();
        });
    }

    @SuppressWarnings("unchecked")
    protected void initTableColumn() {
        TableColumn<T, String> referenceColumn = new TableColumn<>("Référence");
        referenceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        getTableView().getColumns().addAll(referenceColumn);

        initSpecificTableColumns();
    }


    public void initListener() {
        getData().addListener((ListChangeListener<T>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    ajouter(change.getAddedSubList().getFirst());
                }
            }
        });

    }

    public TableView<T> getTableView() {
        return tableView;
    }

    protected abstract void initSpecificTableColumns();
}
