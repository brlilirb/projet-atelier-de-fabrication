package INSA.TD.services.implementation;

import INSA.TD.models.Equipement;
import INSA.TD.services.EquipementService;
import INSA.TD.services.MachineService;
import INSA.TD.services.PosteService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class EquipementServiceImpl extends IdentityService<Equipement> implements EquipementService {

    private static EquipementServiceImpl instance;

    private final MachineService machineService = MachineServiceImpl.getInstance();
    private final PosteService posteService = PosteServiceImpl.getInstance();

    private EquipementServiceImpl() {
    }

    public static EquipementService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EquipementServiceImpl();
        }
        return instance;
    }

    private List<Equipement> concatEquipementList() {
        return Stream.concat(
                        machineService.getAll().stream(),
                        posteService.getAll().stream()
                )
                .toList();
    }

    @Override
    public String getExistMessage() {
        return "La référence de l'équipement existe déjà.";
    }

    @Override
    public Equipement getEquipementById(String id) {
        return getById(concatEquipementList(), id);
    }
}
