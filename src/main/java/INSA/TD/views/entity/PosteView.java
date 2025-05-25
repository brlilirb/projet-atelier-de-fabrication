package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.controllers.EquipementController;
import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.EquipementControllerImpl;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.form.MachinesPosteForm;
import INSA.TD.views.entity.form.PosteForm;
import INSA.TD.views.entity.tableview.MachineTableView;
import INSA.TD.views.entity.tableview.PosteTableView;
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
import java.util.Objects;

public class PosteView extends AbstractEntityView<Poste> {

    private final EquipementController equipementController;
    private ObservableList<Machine> machinesDuPoste;
    private MachineTableView machineTableView;
    private Button deleteMachineButton;
    private Button addMachineButton;
    private ButtonBar buttonBar;
    private VBox vbox;
    private MachinesPosteForm addMachinesForm;

    public PosteView() {
        machinesDuPoste = FXCollections.observableArrayList();
        equipementController = EquipementControllerImpl.getInstance();
        setTop(new TitleBox("Postes"));
    }

    @Override
    protected boolean checkUnique(Poste entity) {
        return Objects.isNull(equipementController.afficher(entity.getId()));
    }

    @Override
    protected PosteController getController() {
        return PosteControllerImpl.getInstance();
    }

    @Override
    protected TableView<Poste> createTableView() {
        PosteTableView posteTableView = new PosteTableView(getData());
        posteTableView.setOnVoirClicked(this::handleVoirMachinesDuPoste);
        return posteTableView;
    }

    @Override
    protected AbstractForm<Poste> createAddForm() {
        return new PosteForm(this::addValue);
    }

    @Override
    protected Node createSpecificNode() {
        vbox = new VBox(ViewConfig.DEFAULT_SPACING);
        vbox.setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
        machineTableView = new MachineTableView(getMachinesDuPoste());
        initPosteActionComponents();
        vbox.getChildren().addAll(machineTableView, buttonBar);
        return vbox;
    }

    public ObservableList<Machine> getMachinesDuPoste() {
        return machinesDuPoste;
    }

    public void setMachinesDuPoste(List<Machine> machinesDuPoste) {
        this.machinesDuPoste = FXCollections.observableArrayList(machinesDuPoste);
    }

    private void handleVoirMachinesDuPoste(Poste poste) {
        setMachinesDuPoste(poste.getListeMachines());
        machineTableView.setItems(getMachinesDuPoste());
        addMachineButton.setDisable(false);
        initAddMachinesButton(poste);
        initDeleteMachinesButton(poste);
    }

    private void initAddMachinesButton(Poste poste) {
        addMachineButton.setOnAction(_ -> {
            addMachinesForm = new MachinesPosteForm(this::addMachines, poste);
            addMachineButton.setDisable(true);
            vbox.getChildren().add(addMachinesForm);
        });
    }

    private void initDeleteMachinesButton(Poste poste) {
        deleteMachineButton.setDisable(true);
        machineTableView.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> {
            deleteMachineButton.setDisable(newValue == null);
            addMachineButton.setDisable(false);
            vbox.getChildren().remove(addMachinesForm);
        });
        deleteMachineButton.setOnAction(_ -> {
            ObservableList<Machine> selectedItems = machineTableView.getSelectionModel().getSelectedItems();
            for (Machine selected : selectedItems) {
                if (selected != null) {
                    poste.getListeMachines().remove(selected);
                }
            }
            getMachinesDuPoste().removeAll(selectedItems); // Supprimer l'objet sélectionné de la liste
            machineTableView.getSelectionModel().clearSelection();
        });
    }

    private void initPosteActionComponents() {
        deleteMachineButton = new Button("Supprimer machine(s)");
        deleteMachineButton.setDisable(true);
        addMachineButton = new Button("Ajouter machine(s)");
        addMachineButton.setDisable(true);
        buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(deleteMachineButton, addMachineButton);
        buttonBar.setVisible(getUserController().getUser().autorisation());
    }

    protected void addMachines(Poste poste) {
        getController().modifier(poste);
        machinesDuPoste.setAll(poste.getListeMachines());
        addMachineButton.setDisable(false);
        vbox.getChildren().remove(addMachinesForm);
    }
}
