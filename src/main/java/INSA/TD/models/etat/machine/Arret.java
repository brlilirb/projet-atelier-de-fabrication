package INSA.TD.models.etat.machine;

import INSA.TD.models.enumeration.EtatExterne;
import INSA.TD.models.enumeration.EtatInterne;

public abstract class Arret extends EtatMachine {

    protected Arret(EtatExterne etatExterne) {
        super(EtatInterne.ARRET, etatExterne);
    }
}
