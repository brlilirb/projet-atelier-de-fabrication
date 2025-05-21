package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.OperateurController;
import INSA.TD.controllers.implementation.OperateurControllerImpl;
import INSA.TD.models.Operateur;

public class OperateurView extends AbstractEntityView<Operateur> {
    private final OperateurController operateurController = OperateurControllerImpl.getInstance();

    @Override
    protected Controller<Operateur> getController() {
        return operateurController;
    }
}
