package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Poste;

public class PosteView extends AbstractEntityView<Poste> {
    private final PosteController posteController = PosteControllerImpl.getInstance();

    @Override
    protected Controller<Poste> getController() {
        return posteController;
    }
}
