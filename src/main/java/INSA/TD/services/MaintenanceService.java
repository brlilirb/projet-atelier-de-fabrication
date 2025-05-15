package INSA.TD.services;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;
import INSA.TD.models.SuiviMaintenance;

import java.util.List;
import java.util.Map;

public interface MaintenanceService extends SaveService {
    Fiabilite computeFiabilite(String machineId);

    List<Fiabilite> computeAllFiabilites();

    void addEvent(SuiviMaintenance event);

    void addStringEvent(String event);

    void deleteAll();

    Map<Machine, Fiabilite> sortMachineByFiability(boolean order);
}
