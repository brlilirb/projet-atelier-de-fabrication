package INSA.TD.services.implementation;

import INSA.TD.models.Gamme;
import INSA.TD.services.GammeService;
import INSA.TD.services.OperationService;

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
}
