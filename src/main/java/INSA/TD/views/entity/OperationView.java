package INSA.TD.views.entity;

import INSA.TD.controllers.OperationController;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.Operation;

public class OperationView extends AbstractEntityView<Operation> {
    @Override
    protected OperationController getController() {
        return OperationControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {

    }//TODO a faire (cf exemple machine)
}
