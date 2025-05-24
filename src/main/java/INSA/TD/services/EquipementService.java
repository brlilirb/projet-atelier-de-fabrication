package INSA.TD.services;

import INSA.TD.models.Equipement;

import java.util.List;

public interface EquipementService {

    List<Equipement> getAllEquipements();

    Equipement getEquipementById(String id);
}
