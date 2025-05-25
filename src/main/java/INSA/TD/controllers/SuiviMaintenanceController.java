package INSA.TD.controllers;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.SuiviMaintenance;

import java.util.List;

public interface SuiviMaintenanceController {
    List<SuiviMaintenance> afficherTous();

    List<SuiviMaintenance> afficher(String machineId);

    SuiviMaintenance ajouter(SuiviMaintenance event);

    void supprimer(Long id);

    Fiabilite calculerFiabilite(String id);

    List<Fiabilite> calculerToutesFiabilites();
}
