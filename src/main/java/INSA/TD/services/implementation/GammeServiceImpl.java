package INSA.TD.services.implementation;

import INSA.TD.models.Gamme;
import INSA.TD.models.Operation;
import INSA.TD.services.GammeService;
import INSA.TD.services.OperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GammeServiceImpl extends EntityService<Gamme> implements GammeService {

    private static GammeServiceImpl instance;

    private final OperationService operationService = OperationServiceImpl.getInstance();

    private GammeServiceImpl() {
    }

    public static GammeService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new GammeServiceImpl();
        }
        return instance;
    }

    @Override
    public String getExistMessage() {
        return "La référence de la gamme existe déjà.";
    }

    @Override
    public double calculerCout(Gamme gamme) {
        return operationService.calculerCout(gamme.getListeOperations());
    }

    @Override
    public double calculerDuree(Gamme gamme) {
        return operationService.calculerDuree(gamme.getListeOperations());
    }

    @Override
    public void clearOperation(String refOperation) {
        for (Gamme gamme : getAll()) {
            gamme.setListeOperations(new ArrayList<>(removeOperationFromGammeAndRefOperation(refOperation, gamme)));
        }
    }

    @Override
    public void clearProduit(String refProduit) {
        for (Gamme gamme : getAll()) {
            if (gamme.getRefProduit().equals(refProduit)) {
                gamme.setRefProduit(null);
            }
        }
    }

    private List<Operation> removeOperationFromGammeAndRefOperation(String refOperation, Gamme gamme) {
        return gamme.getListeOperations()
                .stream()
                .filter(operation -> !operation.getId().equals(refOperation))
                .toList();
    }
}
