package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Machine;
import INSA.TD.services.MachineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MachineServiceImpl extends IdentityService<Machine> implements MachineService {

    private static MachineServiceImpl instance;
    private static final String EXISTE_DEJA = "La référence de machine existe déjà.";
    private List<Machine> listeMachines = new ArrayList<>();

    private MachineServiceImpl() {
        //listeMachines.add(new Machine("soudeuse", 2, 3, 300, "soudeuse3000", "fvqergvfk.2324"));
    }

    public static MachineService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MachineServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Machine> getAll() {
        return listeMachines;
    }

    @Override
    public Machine get(String id) {
        return getById(listeMachines, id);
    }

    @Override
    public Machine add(Machine entity) throws ExistException {
        return add(entity, listeMachines, EXISTE_DEJA);
    }

    @Override
    public Machine update(Machine entity) {
        return update(entity, listeMachines);
    }

    @Override
    public void delete(String id) {
        listeMachines = deleteById(listeMachines, id);
    }


}
