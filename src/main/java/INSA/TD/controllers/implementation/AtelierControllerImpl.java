package INSA.TD.controllers.implementation;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.InitController;
import INSA.TD.models.Machine;
import INSA.TD.services.AtelierService;
import INSA.TD.services.implementation.AtelierServiceImpl;
import INSA.TD.views.View;
import INSA.TD.views.implementation.AtelierViewImpl;

public class AtelierControllerImpl implements InitController, Controller {
    private final AtelierService atelierService = new AtelierServiceImpl();
    private final View atelierView;

    public AtelierControllerImpl() {
        this.atelierView = new AtelierViewImpl(this);
    }

    @Override
    public Machine getMachine(String reference) {
        return atelierService.getMachine(reference);
    }

    @Override
    public void init() {
        //atelierView.afficherMachine();
    }
}
