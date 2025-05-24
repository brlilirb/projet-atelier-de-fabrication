package INSA.TD.controllers.implementation;

import INSA.TD.controllers.EquipementController;
import INSA.TD.models.Equipement;
import INSA.TD.services.EquipementService;
import INSA.TD.services.implementation.EquipementServiceImpl;

import java.util.List;

public class EquipementControllerImpl implements EquipementController {

    private static EquipementControllerImpl instance;

    private final EquipementService equipementService;

    private EquipementControllerImpl() {
        equipementService = EquipementServiceImpl.getInstance();
    }

    public static EquipementController getInstance() {
        if (instance == null) {
            instance = new EquipementControllerImpl();
        }
        return instance;
    }

    @Override
    public List<Equipement> afficherTous() {
        return equipementService.getAllEquipements();
    }

    @Override
    public Equipement afficher(String id) {
        return equipementService.getEquipementById(id);
    }
}
