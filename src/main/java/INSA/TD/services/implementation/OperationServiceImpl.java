package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Operation;
import INSA.TD.services.OperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperationServiceImpl extends IdentityService<Operation> implements OperationService {

    private static OperationServiceImpl instance;
    private static final String EXISTE_DEJA = "La référence de l'opération existe déjà.";
    private List<Operation> listeOperations = new ArrayList<>();

    private OperationServiceImpl() {
    }

    public static OperationService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OperationServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Operation> getAll() {
        return listeOperations;
    }

    @Override
    public Operation get(String id) {
        return getById(listeOperations, id);
    }

    @Override
    public Operation add(Operation entity) throws ExistException {
        return add(entity, listeOperations, EXISTE_DEJA);
    }

    @Override
    public Operation update(Operation entity) {
        return update(entity, listeOperations);
    }

    @Override
    public void delete(String id) {
        listeOperations = deleteById(listeOperations, id);
    }
}
