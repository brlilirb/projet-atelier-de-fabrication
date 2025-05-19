package INSA.TD.controllers.implementation;

import INSA.TD.controllers.OperateurController;
import INSA.TD.models.Operateur;
import INSA.TD.services.OperateurService;
import INSA.TD.services.implementation.OperateurServiceImpl;

public class OperateurControllerImpl extends AbstractEntityController<Operateur> implements OperateurController {

    private static OperateurControllerImpl instance;
    private final OperateurService operateurService = OperateurServiceImpl.getInstance();

    private OperateurControllerImpl() {
    }

    public static OperateurController getInstance() {
        if (instance == null) {
            instance = new OperateurControllerImpl();
        }
        return instance;
    }

    @Override
    protected OperateurService getService() {
        return operateurService;
    }
}
