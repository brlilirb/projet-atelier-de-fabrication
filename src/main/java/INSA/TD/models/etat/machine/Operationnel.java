package INSA.TD.models.etat.machine;

import INSA.TD.models.enumeration.EtatExterne;
import INSA.TD.models.enumeration.EtatInterne;

public abstract class Operationnel extends EtatMachine {

    protected Operationnel(EtatExterne etatExterne) {
        super(EtatInterne.OPERATIONNEL, etatExterne);
    }
}
