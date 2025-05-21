package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.GammeController;
import INSA.TD.controllers.implementation.GammeControllerImpl;
import INSA.TD.models.Gamme;

public class GammeView extends AbstractEntityView<Gamme> {
    private final GammeController gammeController = GammeControllerImpl.getInstance();

    @Override
    protected Controller<Gamme> getController() {
        return gammeController;
    }
}
