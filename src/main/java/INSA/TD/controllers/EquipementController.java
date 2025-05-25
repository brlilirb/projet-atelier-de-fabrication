package INSA.TD.controllers;

import INSA.TD.models.Equipement;

import java.util.List;

public interface EquipementController {

    List<Equipement> afficherTous();

    Equipement afficher(String id);
}
