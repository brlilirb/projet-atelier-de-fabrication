package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.OperationController;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.Operation;

public class OperationView extends AbstractEntityView<Operation> {
    private final OperationController operationController = OperationControllerImpl.getInstance();

    @Override
    protected Controller<Operation> getController() {
        return operationController;
    }
}
