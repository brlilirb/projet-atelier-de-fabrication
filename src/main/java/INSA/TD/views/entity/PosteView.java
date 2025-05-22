package INSA.TD.views.entity;

import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Poste;

public class PosteView extends AbstractEntityView<Poste> {
    @Override
    protected PosteController getController() {
        return PosteControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {

    }//TODO a faire (cf exemple machine)
}
