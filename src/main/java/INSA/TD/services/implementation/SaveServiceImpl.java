package INSA.TD.services.implementation;

import INSA.TD.services.SaveService;

import java.util.List;
import java.util.Objects;

public class SaveServiceImpl implements SaveService {

    private static SaveServiceImpl instance;

    private final SaveService machineService = MachineServiceImpl.getInstance();
    private final SaveService gammeService = GammeServiceImpl.getInstance();
    private final SaveService operationService = OperationServiceImpl.getInstance();
    private final SaveService posteService = PosteServiceImpl.getInstance();
    private final SaveService produitService = ProduitServiceImpl.getInstance();
    private final SaveService maintenanceService = MaintenanceServiceImpl.getInstance();


    private SaveServiceImpl() {
    }

    public static SaveService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SaveServiceImpl();
        }
        return instance;
    }

    private List<SaveService> getAllServices() {
        return List.of(machineService, gammeService, operationService, posteService, produitService, maintenanceService);
    }

    @Override
    public void save() {
        getAllServices().forEach(SaveService::save);
    }

    @Override
    public void load() {
        getAllServices().forEach(SaveService::load);
    }
}
