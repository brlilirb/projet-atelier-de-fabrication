package INSA.TD.services.implementation;

import INSA.TD.models.Machine;
import INSA.TD.services.MachineService;

import java.util.Objects;

public class MachineServiceImpl extends EntityService<Machine> implements MachineService {

    private static MachineServiceImpl instance;

    private MachineServiceImpl() {
        //listeMachines.add(new Machine("soudeuse", 2, 3, 300, "soudeuse3000", "fvqergvfk.2324"));
    }

    public static MachineService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MachineServiceImpl();
        }
        return instance;
    }


}
