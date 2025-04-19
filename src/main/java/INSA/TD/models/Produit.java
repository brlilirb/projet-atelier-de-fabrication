package INSA.TD.models;

public class Produit extends AbstractIdentity {

    public Produit(String code, String designation) {
        this.setProperties(designation, code);
    }
}
