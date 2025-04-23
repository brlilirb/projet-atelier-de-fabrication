package INSA.TD.models.etat.machine;

import INSA.TD.models.enumeration.EtatExterne;

public class Maintenance extends Arret {
    public Maintenance() {
        super(EtatExterne.MAINTENANCE);
    }
}
