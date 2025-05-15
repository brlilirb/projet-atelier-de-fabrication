package INSA.TD.services.implementation;

import INSA.TD.models.Machine;
import INSA.TD.services.MachineService;

import java.util.Objects;

public class MachineServiceImpl extends EntityService<Machine> implements MachineService {

    private static MachineServiceImpl instance;

    private MachineServiceImpl() {
    }

    public static MachineService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MachineServiceImpl();
        }
        return instance;
    }

    @Override
    public String getExistMessage() {
        return "La référence de la machine existe déjà.";
    }
}
