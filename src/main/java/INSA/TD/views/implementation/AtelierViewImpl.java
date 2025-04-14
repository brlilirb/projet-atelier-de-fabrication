package INSA.TD.views.implementation;

import INSA.TD.controllers.Controller;
import INSA.TD.views.View;

public class AtelierViewImpl implements View {
    private final Controller atelierController;

    public AtelierViewImpl(Controller atelierController) {
        this.atelierController = atelierController;
    }


    @Override
    public void afficherMachine() {
        System.out.println(atelierController.getMachine());
    }
}
