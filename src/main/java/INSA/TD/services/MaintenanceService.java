package INSA.TD.services;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;
import INSA.TD.models.SuiviMaintenance;

import java.util.List;
import java.util.Map;

public interface MaintenanceService extends SaveService {
    Fiabilite computeFiabilite(String machineId);

    List<Fiabilite> computeAllFiabilites();

    SuiviMaintenance addEvent(SuiviMaintenance event);

    Map<Machine, Fiabilite> sortMachineByFiability(boolean order);

    List<SuiviMaintenance> getSortedEventsById(String machineId);

    List<SuiviMaintenance> getAll();

    void deleteEvent(Long id);

    void deleteAll();
}
