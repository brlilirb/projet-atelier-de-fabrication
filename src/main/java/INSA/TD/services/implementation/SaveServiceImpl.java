package INSA.TD.services.implementation;

import INSA.TD.services.SaveService;

import java.util.List;
import java.util.Objects;

public class SaveServiceImpl implements SaveService {

    private static SaveServiceImpl instance;

    private final SaveService machineService = MachineServiceImpl.getInstance();

    private SaveServiceImpl() {
    }

    public static SaveService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SaveServiceImpl();
        }
        return instance;
    }

    private List<SaveService> getAllServices() {
        return List.of(machineService);
    }
    //TODO mettre liste services

    @Override
    public void save() {
        getAllServices().forEach(SaveService::save);
    }

    @Override
    public void load() {
        getAllServices().forEach(SaveService::load);

    }
}
