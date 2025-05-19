package INSA.TD.controllers.implementation;

import INSA.TD.controllers.PosteController;
import INSA.TD.models.Poste;
import INSA.TD.services.PosteService;
import INSA.TD.services.implementation.PosteServiceImpl;

public class PosteControllerImpl extends AbstractEntityController<Poste> implements PosteController {

    private static PosteControllerImpl instance;

    private PosteService posteService = PosteServiceImpl.getInstance();

    private PosteControllerImpl() {
    }

    public static PosteController getInstance() {
        if (instance == null) {
            instance = new PosteControllerImpl();
        }
        return instance;
    }

    @Override
    protected PosteService getService() {
        return posteService;
    }
}
