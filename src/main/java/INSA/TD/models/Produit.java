package INSA.TD.models;

public class Produit extends AbstractDescription {

    public Produit(String code, String designation) {
        this.setProperties(designation, code);
    }

}
