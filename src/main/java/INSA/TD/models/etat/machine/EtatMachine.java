package INSA.TD.models.etat.machine;

import INSA.TD.models.enumeration.EtatExterne;
import INSA.TD.models.enumeration.EtatInterne;

public abstract class EtatMachine {

    private final EtatInterne etatInterne;

    private final EtatExterne etatExterne;

    protected EtatMachine(EtatInterne etatInterne, EtatExterne etatExterne) {
        this.etatInterne = etatInterne;
        this.etatExterne = etatExterne;
    }

    public EtatInterne getEtatInterne() {
        return etatInterne;
    }

    public EtatExterne getEtatExterne() {
        return etatExterne;
    }
}
