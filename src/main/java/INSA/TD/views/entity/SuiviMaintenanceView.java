package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.controllers.SuiviMaintenanceController;
import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.SuiviMaintenanceControllerImpl;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.views.button.AddButton;
import INSA.TD.views.button.DeleteButton;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.form.SuiviMaintenanceForm;
import INSA.TD.views.entity.tableview.SuiviMaintenanceTableView;
import INSA.TD.views.label.TitleBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.Objects;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public class SuiviMaintenanceView extends BorderPane {

    private ObservableList<SuiviMaintenance> data;

    private final SuiviMaintenanceController suiviMaintenanceController;
    private final UserController userController;

    private final TableView<SuiviMaintenance> tableView;

    private final Button deleteButton = new DeleteButton();
    private final Button addButton = new AddButton();
    private final BorderPane borderPane = new BorderPane();
    private final VBox vbox = new VBox(ViewConfig.DEFAULT_SPACING);

    private AbstractForm<SuiviMaintenance> addForm;

    public SuiviMaintenanceView() {
        suiviMaintenanceController = SuiviMaintenanceControllerImpl.getInstance();
        userController = UserControllerImpl.getInstance();

        setTop(new TitleBox("Suivi maintenance"));

        setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
        data = FXCollections.observableArrayList(suiviMaintenanceController.afficherTous());
        tableView = new SuiviMaintenanceTableView(data);

        vbox.getChildren().addAll(tableView, borderPane);
        vbox.setSpacing(DEFAULT_SPACING);
        vbox.setPadding(new Insets(DEFAULT_SPACING));

        setCenter(vbox);

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setEditable(userController.getUser().autorisation());

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
            ObservableList<SuiviMaintenance> selectedItems = tableView.getSelectionModel().getSelectedItems();
            for (SuiviMaintenance selected : selectedItems) {
                if (selected != null) {
                    suiviMaintenanceController.supprimer(selected.getId());
                }
            }
            data.removeAll(selectedItems); // Supprimer l'objet sélectionné de la liste
            tableView.getSelectionModel().clearSelection();
        });
    }

    protected void addValue(SuiviMaintenance entity) {
        if (Objects.nonNull(entity)) {
            data.add(entity);
            suiviMaintenanceController.ajouter(entity);
            borderPane.setCenter(null);
            borderPane.setBottom(null);
        } else {
            addForm.getErrorLabel().setText("Le suivi maintenance ne peut pas être vide.");
            addForm.getErrorLabel().setVisible(true);
        }
    }

    private void initAddButton() {
        addButton.setOnAction(_ -> {
            if (Objects.isNull(borderPane.getCenter())) {
                addForm = new SuiviMaintenanceForm(this::addValue);
                borderPane.setCenter(addForm);
            }
        });
    }
}
