package INSA.TD.services.implementation;

import INSA.TD.models.Equipement;
import INSA.TD.models.Operation;
import INSA.TD.services.EquipementService;
import INSA.TD.services.OperationService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OperationServiceImpl extends EntityService<Operation> implements OperationService {

    private static OperationServiceImpl instance;

    private final EquipementService equipementService = EquipementServiceImpl.getInstance();

    private OperationServiceImpl() {
    }

    public static OperationService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OperationServiceImpl();
        }
        return instance;
    }

    private double getCoutHoraire(Operation operation) {
        return Optional.ofNullable(equipementService.getEquipementById(operation.getRefEquipement()))
                .map(Equipement::calculerCoutHoraire)
                .orElse(0.0);
    }

    @Override
    public double calculerCout(Operation operation) {
        return getCoutHoraire(operation) * operation.getDureeOperation();
    }

    @Override
    public double calculerCout(List<Operation> operations) {
        return operations.stream()
                .mapToDouble(this::calculerCout)
                .sum();
    }

    @Override
    public double calculerDuree(List<Operation> operations) {
        return operations.stream()
                .mapToDouble(Operation::getDureeOperation)
                .sum();
    }

    @Override
    public String getExistMessage() {
        return "La référence de l'opération existe déjà.";
    }
}
