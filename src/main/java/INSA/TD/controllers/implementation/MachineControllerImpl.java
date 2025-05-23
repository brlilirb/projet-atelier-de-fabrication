package INSA.TD.controllers.implementation;

import INSA.TD.controllers.MachineController;
import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;
import INSA.TD.services.MachineService;
import INSA.TD.services.implementation.MachineServiceImpl;
import INSA.TD.services.implementation.MaintenanceServiceImpl;

import java.util.Map;

public class MachineControllerImpl extends AbstractEntityController<Machine> implements MachineController {

    private static MachineControllerImpl instance;
    private final MachineService machineService = MachineServiceImpl.getInstance();
    private final MaintenanceServiceImpl maintenanceService = MaintenanceServiceImpl.getInstance();

    private MachineControllerImpl() {
    }

    public static MachineController getInstance() {
        if (instance == null) {
            instance = new MachineControllerImpl();
        }
        return instance;
    }

    public Map<Machine, Fiabilite> trierMachinesParFiabilite() {
        return maintenanceService.sortMachineByFiability(true);
    }


    @Override
    protected MachineService getService() {
        return machineService;
    }
}
