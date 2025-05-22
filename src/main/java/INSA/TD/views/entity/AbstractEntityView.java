package INSA.TD.views.entity;

import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.views.button.DeleteButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final UserController userController;
    private final TableView<T> tableView = new TableView<>();
    private final Button deleteButton = new DeleteButton();

    protected AbstractEntityView() {
        super();
        userController = UserControllerImpl.getInstance();
        setSpacing(DEFAULT_SPACING);
        setPadding(new Insets(DEFAULT_SPACING));

        getChildren().addAll(tableView, deleteButton);

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(userController.getUser().autorisation());

        initTableColumn();

        tableView.setItems(getData());

        deleteButton.setVisible(userController.getUser().autorisation());
        if (userController.getUser().autorisation()) {
            initDeleteButton();
        }
    }

    private void initDeleteButton() {
        deleteButton.setDisable(true);
        tableView.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> deleteButton.setDisable(newValue == null));
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

    protected UserController getUserController() {
        return userController;
    }

    protected TableView<T> getTableView() {
        return tableView;
    }

    protected abstract void initSpecificTableColumns();
}
