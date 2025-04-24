package INSA.TD.services.implementation;

import INSA.TD.models.Operation;
import INSA.TD.services.OperationService;

import java.util.Objects;

public class OperationServiceImpl extends EntityService<Operation> implements OperationService {

    private static OperationServiceImpl instance;

    private OperationServiceImpl() {
    }

    public static OperationService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OperationServiceImpl();
        }
        return instance;
    }

    @Override
    public String getExistMessage() {
        return "La référence de l'opération existe déjà.";
    }
}
