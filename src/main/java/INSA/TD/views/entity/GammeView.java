package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.controllers.GammeController;
import INSA.TD.controllers.implementation.GammeControllerImpl;
import INSA.TD.models.Gamme;
import INSA.TD.models.Operation;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.form.GammeForm;
import INSA.TD.views.entity.form.GammeOperationForm;
import INSA.TD.views.entity.tableview.GammeTableView;
import INSA.TD.views.entity.tableview.OperationTableView;
import INSA.TD.views.label.TitleBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.List;

public class GammeView extends AbstractEntityView<Gamme> {

    private ObservableList<Operation> operations;
    private OperationTableView operationTableView;
    private Button deleteOperationButton;
    private Button addOperationButton;
    private ButtonBar buttonBar;
    private VBox vbox;
    private GammeOperationForm gammeOperationForm;

    public GammeView() {
        setTop(new TitleBox("Gammes"));
    }

    @Override
    protected GammeController getController() {
        return GammeControllerImpl.getInstance();
    }

    @Override
    protected TableView<Gamme> createTableView() {
        GammeTableView gammeTableView = new GammeTableView(getData());
        gammeTableView.setOnVoirClicked(this::handleVoirOperationGamme);
        return gammeTableView;
    }

    @Override
    protected AbstractForm<Gamme> createAddForm() {
        return new GammeForm(this::addValue);
    }

    @Override
    protected Node createSpecificNode() {
        vbox = new VBox(ViewConfig.DEFAULT_SPACING);
        vbox.setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
        operationTableView = new OperationTableView(getOperationsOnGamme());
        initActionComponents();
        vbox.getChildren().addAll(operationTableView, buttonBar);
        return vbox;
    }

    private void handleVoirOperationGamme(Gamme gamme) {
        setOperationsOnGamme(gamme.getListeOperations());
        operationTableView.setItems(getOperationsOnGamme());
        addOperationButton.setDisable(false);
        initAddOperationButton(gamme);
        initDeleteOperationButton(gamme);
    }

    private void initActionComponents() {
        deleteOperationButton = new Button("Supprimer opération(s)");
        deleteOperationButton.setDisable(true);
        addOperationButton = new Button("Ajouter opération(s)");
        addOperationButton.setDisable(true);
        buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(deleteOperationButton, addOperationButton);
        buttonBar.setVisible(getUserController().getUser().autorisation());
    }

    private void initAddOperationButton(Gamme gamme) {
        addOperationButton.setOnAction(_ -> {
            gammeOperationForm = new GammeOperationForm(this::addOperations, gamme);
            addOperationButton.setDisable(true);
            vbox.getChildren().add(gammeOperationForm);
        });
    }

    private void initDeleteOperationButton(Gamme gamme) {
        deleteOperationButton.setDisable(true);
        operationTableView.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> {
            deleteOperationButton.setDisable(newValue == null);
            addOperationButton.setDisable(false);
            vbox.getChildren().remove(gammeOperationForm);
        });
        deleteOperationButton.setOnAction(_ -> {
            ObservableList<Operation> selectedItems = operationTableView.getSelectionModel().getSelectedItems();
            for (Operation selected : selectedItems) {
                if (selected != null) {
                    gamme.getListeOperations().remove(selected);
                }
            }
            getOperationsOnGamme().removeAll(selectedItems); // Supprimer l'objet sélectionné de la liste
            operationTableView.getSelectionModel().clearSelection();
        });
    }

    protected void addOperations(Gamme gamme) {
        getController().modifier(gamme);
        operations.setAll(gamme.getListeOperations());
        addOperationButton.setDisable(false);
        vbox.getChildren().remove(gammeOperationForm);
    }

    public ObservableList<Operation> getOperationsOnGamme() {
        return operations;
    }

    public void setOperationsOnGamme(List<Operation> operations) {
        this.operations = FXCollections.observableArrayList(operations);
    }
}
