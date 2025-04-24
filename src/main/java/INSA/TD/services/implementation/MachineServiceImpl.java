package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Machine;
import INSA.TD.services.MachineService;

import java.util.Objects;

public class MachineServiceImpl extends EntityService<Machine> implements MachineService {

    private static MachineServiceImpl instance;

    private MachineServiceImpl() {
        try {
            add(new Machine("soudeuse", 2, 3, 300, "soudeuse3000", "fvqergvfk.2324"));
            add(new Machine("soudeuse", 2, 3, 300, "soudeuse3000", "fvqergvfk.2324"));
        } catch (ExistException e) {
            System.out.println(e.getMessage());
        }

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
