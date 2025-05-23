package INSA.TD.views.entity;

import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.views.button.DeleteButton;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final UserController userController;
    private final TableView<T> tableView;
    private final Button deleteButton = new DeleteButton();
    private final Node specificNode;

    protected AbstractEntityView() {
        super();
        tableView = createTableView();
        userController = UserControllerImpl.getInstance();
        specificNode = createSpecificNode();
        setSpacing(DEFAULT_SPACING);
        setPadding(new Insets(DEFAULT_SPACING));

        getChildren().addAll(tableView, deleteButton);

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(userController.getUser().autorisation());

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

    protected UserController getUserController() {
        return userController;
    }

    protected TableView<T> getTableView() {
        return tableView;
    }

    protected abstract TableView<T> createTableView();

    protected abstract Node createSpecificNode();
}
