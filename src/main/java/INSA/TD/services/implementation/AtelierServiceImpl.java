package INSA.TD.services.implementation;

import INSA.TD.models.Machine;
import INSA.TD.services.AtelierService;
import INSA.TD.services.MachineService;

import java.util.Objects;

public class AtelierServiceImpl implements AtelierService {
    private static AtelierServiceImpl instance;
    private final MachineService machineService = MachineServiceImpl.getInstance();

    private AtelierServiceImpl() {
    }

    public static AtelierService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new AtelierServiceImpl();
        }
        return instance;
    }

    @Override
    public Machine getMachine(String reference) {
        return machineService.get(reference);
    }
}
