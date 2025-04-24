package INSA.TD.models.etat.machine;

import INSA.TD.models.enumeration.EtatExterne;

public class Panne extends Arret {

    public Panne() {
        super(EtatExterne.PANNE);
    }
}
