package INSA.TD.controllers;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.SuiviMaintenance;

import java.util.List;

public interface SuiviMaintenanceController {
    List<SuiviMaintenance> afficherTous();

    List<SuiviMaintenance> afficher(String machineId);

    SuiviMaintenance ajouter(SuiviMaintenance event);

    SuiviMaintenance modifier(SuiviMaintenance entity);

    void supprimer(String id);

    Fiabilite calculerFiabilite(String id);

    List<Fiabilite> calculerToutesFiabilites();
    //TODO ajouter sortMachineByFiability ici ou dans MachineController ?
}
