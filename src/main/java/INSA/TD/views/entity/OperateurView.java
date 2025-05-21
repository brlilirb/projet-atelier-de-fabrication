package INSA.TD.views.entity;

import INSA.TD.controllers.OperateurController;
import INSA.TD.controllers.implementation.OperateurControllerImpl;
import INSA.TD.models.Operateur;

public class OperateurView extends AbstractEntityView<Operateur> {
    @Override
    protected OperateurController getController() {
        return OperateurControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {

    }//TODO a faire (cf exemple machine)
}
