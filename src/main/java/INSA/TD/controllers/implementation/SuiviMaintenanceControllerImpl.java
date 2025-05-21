package INSA.TD.controllers.implementation;

import INSA.TD.controllers.SuiviMaintenanceController;
import INSA.TD.models.Fiabilite;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.services.MaintenanceService;
import INSA.TD.services.implementation.MaintenanceServiceImpl;

import java.util.List;

public class SuiviMaintenanceControllerImpl implements SuiviMaintenanceController {

    private static SuiviMaintenanceControllerImpl instance;
    private final MaintenanceService maintenanceService = MaintenanceServiceImpl.getInstance();

    private SuiviMaintenanceControllerImpl() {
    }

    public static SuiviMaintenanceController getInstance() {
        if (instance == null) {
            instance = new SuiviMaintenanceControllerImpl();
        }
        return instance;
    }

    @Override
    public List<SuiviMaintenance> afficherTous() {
        return maintenanceService.getAll();
    }

    @Override
    public List<SuiviMaintenance> afficher(String machineId) {
        return maintenanceService.getSortedEventsById(machineId);
    }

    @Override
    public SuiviMaintenance ajouter(SuiviMaintenance event) {
        return maintenanceService.addEvent(event);
    }

    @Override
    public SuiviMaintenance modifier(SuiviMaintenance entity) {
        return maintenanceService.update(entity);
    }

    @Override
    public void supprimer(SuiviMaintenance event) {
        maintenanceService.deleteEvent(event);
    }

    @Override
    public Fiabilite calculerFiabilite(String id) {
        return maintenanceService.computeFiabilite(id);
    }

    @Override
    public List<Fiabilite> calculerToutesFiabilites() {
        return maintenanceService.computeAllFiabilites();
    }
}
