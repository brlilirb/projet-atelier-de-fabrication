package INSA.TD.views.entity;

import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.views.entity.TableauPosteView;
import INSA.TD.views.entity.MachineView;
import INSA.TD.views.entity.PosteView;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.w3c.dom.Text;
import javafx.scene.control.TextField;


import java.util.List;

public class PosteView extends Pane {

    private final TableauPosteView posteTableView = new TableauPosteView();
    private final MachineView machineView = new MachineView();
    private Label listePoste=new Label("liste des postes :");
    private Label listMachine=new Label("liste des machines de ce poste");

    public PosteView() {
        // position des tableaux
        posteTableView.setLayoutX(20);
        posteTableView.setLayoutY(45);

        machineView.setLayoutX(450);
        machineView.setLayoutY(45);

        listePoste.setLayoutX(20);
        listePoste.setLayoutY(20);

        listMachine.setLayoutX(450);
        listMachine.setLayoutY(20);

        getChildren().addAll(posteTableView,listePoste,listMachine, machineView);
        posteTableView.setOnVoirClicked(this::handleVoirMachinesDuPoste);
    }

    private void handleVoirMachinesDuPoste(Poste poste) {
        List<Machine> machinesDuPoste = poste.getListeMachines();
        machineView.updateTableData(machinesDuPoste);
    }
}
