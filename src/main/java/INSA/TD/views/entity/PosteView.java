package INSA.TD.views.entity;

import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.views.entity.TableauPosteView;
import INSA.TD.views.entity.MachineView;
import INSA.TD.views.entity.PosteView;
import javafx.scene.layout.HBox;

import java.util.List;

public class PosteView extends HBox {

    private final TableauPosteView posteTableView = new TableauPosteView();
    private final MachineView machineView = new MachineView();

    public PosteView() {
        setSpacing(20);
        getChildren().addAll(posteTableView, machineView);

        posteTableView.setOnVoirClicked(this::handleVoirMachinesDuPoste);
    }

    private void handleVoirMachinesDuPoste(Poste poste) {
        List<Machine> machinesDuPoste = poste.getListeMachines();
        machineView.updateTableData(machinesDuPoste);
    }
}
