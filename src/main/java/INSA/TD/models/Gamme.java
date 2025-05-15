package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.ListUtils;

import java.util.List;

public class Gamme extends AbstractIdentity {
    private String refProduit;
    private List<Operation> listeOperations;

    public Gamme() {
    }

    public Gamme(String ref,
                 List<Operation> ope,
                 String refProduit) {
        this.setId(ref);
        this.listeOperations = ope;
        this.refProduit = refProduit;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(List<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString() + delimiter
                + ListUtils.listRefToString(listeOperations, delimiter);
    }
}
