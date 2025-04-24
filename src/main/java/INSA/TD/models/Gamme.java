package INSA.TD.models;

import java.util.ArrayList;

public class Gamme extends AbstractIdentity {

    private ArrayList<Operation> listeOperations;

    public Gamme(String ref,
                 ArrayList<Operation> ope) {
        this.setId(ref);
        this.listeOperations = ope;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }
}
