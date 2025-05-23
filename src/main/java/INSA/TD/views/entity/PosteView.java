package INSA.TD.views.entity;

import INSA.TD.controllers.implementation.AbstractEntityController;
import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.views.button.AddButton;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.views.entity.TableauPosteView;
import INSA.TD.views.entity.MachineView;
import INSA.TD.views.entity.PosteView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


import java.util.ArrayList;
import java.util.List;

public class PosteView extends Pane {

    private final TableauPosteView posteTableView = new TableauPosteView();
    private final MachineView machineView = new MachineView();
    private Label listePoste=new Label("liste des postes :");
    private Label listMachine=new Label("liste des machines de ce poste");
    private Label addPosteText=new Label("ajouter un poste");
    private AddButton add=new AddButton();

    public PosteView() {
        // position des objets
        posteTableView.setLayoutX(20);posteTableView.setLayoutY(45);

        machineView.setLayoutX(450);machineView.setLayoutY(45);

        listePoste.setLayoutX(20);listePoste.setLayoutY(20);

        listMachine.setLayoutX(450);listMachine.setLayoutY(20);

        addPosteText.setLayoutX(20);addPosteText.setLayoutY(500);

        add.setLayoutX(120);
        add.setLayoutY(500);
        add.setOnAction(event -> {
            List<Machine> nouveauMachine= new ArrayList<>();
            nouveauMachine.add(new Machine("",0,0,0,"","nouveau"));
            Poste poste=new Poste(nouveauMachine,"","nouveau");
            poste.setProperties("","nouveau");
            System.out.println(poste);
            PosteControllerImpl.getInstance().ajouter(poste);
            posteTableView.updateData(PosteControllerImpl.getInstance().afficherTous());

        });

        getChildren().addAll(posteTableView,listePoste,listMachine,addPosteText,add, machineView);
        posteTableView.setOnVoirClicked(this::handleVoirMachinesDuPoste);
    }

    private void handleVoirMachinesDuPoste(Poste poste) {
        List<Machine> machinesDuPoste = poste.getListeMachines();
        machineView.updateTableData(machinesDuPoste);
    }
}
