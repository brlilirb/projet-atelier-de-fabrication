package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.views.button.AddButton;
import INSA.TD.views.button.DeleteButton;
import INSA.TD.views.entity.form.AbstractForm;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.Objects;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final UserController userController;
    private final TableView<T> tableView;
    private final Button deleteButton = new DeleteButton();
    private final Button addButton = new AddButton();
    private final BorderPane borderPane = new BorderPane();
    private final VBox vbox = new VBox(ViewConfig.DEFAULT_SPACING);
    private final Node specificNode;
    private AbstractForm<T> addForm;

    protected AbstractEntityView() {
        super();
        tableView = createTableView();
        userController = UserControllerImpl.getInstance();
        specificNode = createSpecificNode();
        setPadding(new Insets(DEFAULT_SPACING));

        vbox.getChildren().addAll(tableView, borderPane);
        vbox.setSpacing(DEFAULT_SPACING);
        vbox.setPadding(new Insets(DEFAULT_SPACING));

        setCenter(vbox);
        setRight(specificNode);

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
        if (Objects.nonNull(entity) && checkUnique(entity)) {
            getData().add(entity);
            getController().ajouter(entity);
            borderPane.setCenter(null);
            borderPane.setBottom(null);
        } else {
            addForm.getErrorLabel().setText("La référence existe déjà, veuillez en saisir une autre.");
            addForm.getErrorLabel().setVisible(true);
        }
    }

    protected boolean checkUnique(T entity) {
        return Objects.isNull(getController().afficher(entity.getId()));
    }

    private void initAddButton() {
        addButton.setOnAction(_ -> {
            if (Objects.isNull(borderPane.getCenter())) {
                addForm = createAddForm();
                borderPane.setCenter(addForm);
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
