package INSA.TD.views.implementation;

import INSA.TD.controllers.Controller;
import INSA.TD.utils.Lire;
import INSA.TD.views.AtelierView;
import INSA.TD.views.MachineView;

public class AtelierViewImpl implements AtelierView {
    private final Controller atelierController;
    private final MachineView machineView;

    public AtelierViewImpl(Controller atelierController) {
        this.atelierController = atelierController;
        this.machineView = new MachineViewImpl(atelierController);
    }

    public void init() {
        int reponse = -1;
        while (reponse != 0) {
            System.out.println("Voulez-vous accéder à:");
            System.out.println("1 Machine");
            System.out.println("2 Poste");
            System.out.println("3 Gamme");
            System.out.println("0 pour quitter le programme");
            reponse = Lire.i();
            switch (reponse) {
                case 1:
                    machineView.choix();
                    break;
                default:
                    break;
            }
        }
    }
}
