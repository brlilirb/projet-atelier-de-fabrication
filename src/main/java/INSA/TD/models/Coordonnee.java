package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;

public class Coordonnee {

    private float abscisse;

    private float ordonnee;

    public Coordonnee(float abscisse, float ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public float getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(float abscisse) {
        this.abscisse = abscisse;
    }

    public float getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(float ordonnee) {
        this.ordonnee = ordonnee;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return abscisse + delimiter + ordonnee;
    }
}
