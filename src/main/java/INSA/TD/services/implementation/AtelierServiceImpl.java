package INSA.TD.services.implementation;

import INSA.TD.services.AtelierService;
import INSA.TD.services.MachineService;

public class AtelierServiceImpl implements AtelierService {

    private final MachineService machineService = new MachineServiceImpl();

    @Override
    public String getMachine() {
        return machineService.get();
    }
}
