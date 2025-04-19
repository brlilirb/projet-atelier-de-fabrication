package INSA.TD.models;

import java.util.ArrayList;

public class Gamme extends AbstractIdentity {
    private String refGamme;
    private ArrayList<Operation> listeOperations;

    public Gamme(String ref,
                 ArrayList<Operation> ope,
                 ArrayList<AbstractIdentity> equipement) {
        this.setId(ref);
        this.listeOperations = ope;
    }

    public String getRefGamme() {
        return refGamme;
    }

    public void setRefGamme(String refGamme) {
        this.refGamme = refGamme;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }
}
