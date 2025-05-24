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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Objects;

public class PosteView extends AbstractEntityView<Poste> {

    private final EquipementController equipementController;
    private ObservableList<Machine> machinesDuPoste;
    private final PosteTableView posteTableView;

    public PosteView() {
        super();
        equipementController = EquipementControllerImpl.getInstance();
        posteTableView = new PosteTableView(getData());
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
        return posteTableView;
    }

    @Override
    protected AbstractForm<Poste> createAddForm() {
        return null;
    }

    @Override
    protected Node createSpecificNode() {
        posteTableView.setOnVoirClicked(this::handleVoirMachinesDuPoste); //TODO fix bug
        return new MachineTableView(machinesDuPoste);
    }

    public ObservableList<Machine> getMachinesDuPoste() {
        return machinesDuPoste;
    }

    public void setMachinesDuPoste(List<Machine> machinesDuPoste) {
        this.machinesDuPoste = FXCollections.observableArrayList(machinesDuPoste);
    }

    private void handleVoirMachinesDuPoste(Poste poste) {
        setMachinesDuPoste(poste.getListeMachines());
    }
}
