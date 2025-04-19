package INSA.TD.services.implementation;

import INSA.TD.models.Machine;
import INSA.TD.services.AtelierService;
import INSA.TD.services.MachineService;

public class AtelierServiceImpl implements AtelierService {

    private final MachineService machineService = new MachineServiceImpl();

    @Override
    public Machine getMachine(String reference) {
        return machineService.get(reference);
    }
}
