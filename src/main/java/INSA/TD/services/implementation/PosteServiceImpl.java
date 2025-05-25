package INSA.TD.services.implementation;

import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.services.PosteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PosteServiceImpl extends EntityService<Poste> implements PosteService {

    private static PosteServiceImpl instance;

    private PosteServiceImpl() {
    }

    public static PosteService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PosteServiceImpl();
        }
        return instance;
    }

    @Override
    public String getExistMessage() {
        return "La référence du poste existe déjà.";
    }

    @Override
    public void clearMachine(String refMachine) {
        for (Poste poste : getAll()) {
            poste.setListeMachines(new ArrayList<>(removeMachineFromPosteAndRefMachine(refMachine, poste)));
        }
    }

    private List<Machine> removeMachineFromPosteAndRefMachine(String refMachine, Poste poste) {
        return poste.getListeMachines()
                .stream()
                .filter(machine -> !machine.getId().equals(refMachine))
                .toList();
    }
}
