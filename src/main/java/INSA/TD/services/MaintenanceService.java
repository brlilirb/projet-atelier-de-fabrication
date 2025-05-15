package INSA.TD.services;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.SuiviMaintenance;

import java.util.List;

public interface MaintenanceService extends SaveService {
    Fiabilite computeFiabilite(String machineId);

    List<Fiabilite> computeAllFiabilites();

    void addEvent(SuiviMaintenance event);

    void addStringEvent(String event);

    void deleteAll();
}
