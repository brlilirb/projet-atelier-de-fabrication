package INSA.TD.views.implementation;

import INSA.TD.controllers.Controller;
import INSA.TD.models.Machine;
import INSA.TD.utils.Lire;
import INSA.TD.views.MachineView;

import java.util.Objects;

public class MachineViewImpl implements MachineView {
    private final Controller controller;

    public MachineViewImpl(Controller atelierController) {
        controller = atelierController;
    }

    @Override
    public void afficher(Machine entity) {

        System.out.println(Objects.nonNull(entity) ? entity : "La référence n'existe pas");
    }

    @Override
    public void choix() {
        int reponse = -1;
        while (reponse != 0) {
            System.out.println("[Machines]");
            System.out.println("1 Afficher");
            System.out.println("2 Créer");
            System.out.println("0 Quitter");
            reponse = Lire.i();

            switch (reponse) {
                case 1:
                    afficher();
                    break;
                default:
                    break;
            }
        }
    }

    public void afficher() {
        String reponse = "";
        while (!Objects.equals(reponse, "0")) {
            System.out.println("Donnez la référence de la machine.");

            //TODO message end
            reponse = Lire.S();

            if (!Objects.equals(reponse, "0")) {
                afficher(controller.getMachine(reponse));
            }
        }
    }
}
