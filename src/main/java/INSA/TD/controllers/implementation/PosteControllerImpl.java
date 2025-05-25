package INSA.TD.controllers.implementation;

import INSA.TD.controllers.PosteController;
import INSA.TD.models.Poste;
import INSA.TD.services.OperationService;
import INSA.TD.services.PosteService;
import INSA.TD.services.implementation.OperationServiceImpl;
import INSA.TD.services.implementation.PosteServiceImpl;

public class PosteControllerImpl extends AbstractEntityController<Poste> implements PosteController {

    private static PosteControllerImpl instance;

    private final OperationService operationService = OperationServiceImpl.getInstance();
    private final PosteService posteService = PosteServiceImpl.getInstance();

    private PosteControllerImpl() {
    }

    public static PosteController getInstance() {
        if (instance == null) {
            instance = new PosteControllerImpl();
        }
        return instance;
    }

    @Override
    public void supprimer(String id) {
        operationService.clearEquipement(id);
        super.supprimer(id);
    }

    @Override
    protected PosteService getService() {
        return posteService;
    }
}
