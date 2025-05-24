package INSA.TD.views.entity;

import INSA.TD.controllers.EquipementController;
import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.EquipementControllerImpl;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.tableview.MachineTableView;
import INSA.TD.views.entity.tableview.PosteTableView;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Objects;

public class PosteView extends AbstractEntityView<Poste> {

    private final EquipementController equipementController;
    private ObservableList<Machine> machinesDuPoste;
    private MachineTableView machineTableView;

    public PosteView() {
        super();
        machinesDuPoste = FXCollections.observableArrayList();
        equipementController = EquipementControllerImpl.getInstance();
        this.setTop(new H1TitleLabel("Postes"));
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
        return null;
    }

    @Override
    protected Node createSpecificNode() {
        machineTableView = new MachineTableView(getMachinesDuPoste());
        return machineTableView;
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
    }
}
