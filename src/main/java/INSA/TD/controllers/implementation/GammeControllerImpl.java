package INSA.TD.controllers.implementation;

import INSA.TD.controllers.GammeController;
import INSA.TD.models.Gamme;
import INSA.TD.services.GammeService;
import INSA.TD.services.implementation.GammeServiceImpl;

public class GammeControllerImpl extends AbstractEntityController<Gamme> implements GammeController {

    private static GammeControllerImpl instance;

    private final GammeService gammeService = GammeServiceImpl.getInstance();

    private GammeControllerImpl() {
    }

    public static GammeController getInstance() {
        if (instance == null) {
            instance = new GammeControllerImpl();
        }
        return instance;
    }

    @Override
    protected GammeService getService() {
        return gammeService;
    }

    @Override
    public double calculerCout(Gamme gamme) {
        return gammeService.calculerCout(gamme);
    }

    @Override
    public double calculerDuree(Gamme gamme) {
        return gammeService.calculerDuree(gamme);
    }
}
