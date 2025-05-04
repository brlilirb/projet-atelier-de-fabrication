package INSA.TD.services.implementation;

import INSA.TD.services.SaveService;

import java.util.List;

public class SaveServiceImpl implements SaveService {
    private SaveService machineService = MachineServiceImpl.getInstance();

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
