package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;

public class Operateur extends Personne {

    private boolean libre;

    public Operateur(String id, String nom, String prenom) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.libre = true;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString(delimiter) + delimiter
                + libre;
    }
}
