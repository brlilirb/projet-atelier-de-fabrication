package INSA.TD.services;

import INSA.TD.models.Operation;

import java.util.List;

public interface OperationService extends Service<Operation>, SaveService {
    double calculerCout(Operation operation);

    double calculerCout(List<Operation> operations);

    double calculerDuree(List<Operation> operations);

    void clearEquipement(String refEquipement);
}
