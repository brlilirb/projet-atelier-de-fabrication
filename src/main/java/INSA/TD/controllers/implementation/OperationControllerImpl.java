package INSA.TD.controllers.implementation;

import INSA.TD.controllers.OperationController;
import INSA.TD.models.Operation;
import INSA.TD.services.OperationService;
import INSA.TD.services.implementation.OperationServiceImpl;

public class OperationControllerImpl extends AbstractEntityController<Operation> implements OperationController {

    private static OperationControllerImpl instance;

    private final OperationService operationService = OperationServiceImpl.getInstance();

    private OperationControllerImpl() {
    }

    public static OperationController getInstance() {
        if (instance == null) {
            instance = new OperationControllerImpl();
        }
        return instance;
    }

    @Override
    protected OperationService getService() {
        return operationService;
    }
}
