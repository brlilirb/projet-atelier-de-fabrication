package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;

public abstract class Personne extends AbstractIdentity {

    private String nom;

    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString() + delimiter
                + nom + delimiter
                + prenom;

    }


}
