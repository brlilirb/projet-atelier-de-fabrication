package INSA.TD.views.entity;

import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.views.button.AddButton;
import INSA.TD.views.button.DeleteButton;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.label.ErrorLabel;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.util.Objects;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final UserController userController;
    private final TableView<T> tableView;
    private final Button deleteButton = new DeleteButton();
    private final Button addButton = new AddButton();
    private final BorderPane borderPane = new BorderPane();
    private final Node specificNode;

    protected AbstractEntityView() {
        super();
        tableView = createTableView();
        userController = UserControllerImpl.getInstance();
        specificNode = createSpecificNode();
        setSpacing(DEFAULT_SPACING);
        setPadding(new Insets(DEFAULT_SPACING));

        getChildren().addAll(tableView, borderPane);

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(userController.getUser().autorisation());

        borderPane.setVisible(userController.getUser().autorisation());
        initActionComponents();
    }

    private void initActionComponents() {
        if (userController.getUser().autorisation()) {
            initDeleteButton();
            initAddButton();
            ButtonBar buttonBar = new ButtonBar();
            buttonBar.getButtons().addAll(deleteButton, addButton);
            borderPane.setLeft(buttonBar);
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

    protected void addValue(T entity) {
        if (Objects.nonNull(entity) && getData().stream().noneMatch(e -> e.getId().equals(entity.getId()))) {
            getData().add(entity);
            getController().ajouter(entity);
            borderPane.setCenter(null);
            borderPane.setBottom(null);
        } else {
            borderPane.setBottom(
                    new ErrorLabel("La référence existe déjà, veuillez en saisir une autre.")
            );
        }
    }

    private void initAddButton() {
        addButton.setOnAction(_ -> {
            if (Objects.isNull(borderPane.getCenter())) {
                borderPane.setCenter(createAddForm());
            }
        });
    }

    protected UserController getUserController() {
        return userController;
    }

    protected TableView<T> getTableView() {
        return tableView;
    }

    protected abstract TableView<T> createTableView();

    protected abstract AbstractForm<T> createAddForm();

    protected abstract Node createSpecificNode();
}
