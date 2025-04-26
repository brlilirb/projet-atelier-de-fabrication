package INSA.TD.models;

import INSA.TD.models.etat.machine.Disponible;
import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.utils.ConstantesUtils;

public class Machine extends Equipement {
    private String type;
    private float cout;
    private Coordonnee coordonnee;
    private EtatMachine etatMachine;

    public Machine(String type,
                   float ordonnee,
                   float abscisse,
                   float cout,
                   String dEquipement,
                   String refEquipement,
                   EtatMachine etatMachine) {
        this(
                type,
                ordonnee,
                abscisse,
                cout,
                dEquipement,
                refEquipement
        );
        this.etatMachine = etatMachine;
    }

    public Machine(String type,
                   float ordonnee,
                   float abscisse,
                   float cout,
                   String dEquipement,
                   String refEquipement) {
        this.type = type;
        this.cout = cout;
        this.setProperties(dEquipement, refEquipement);
        this.coordonnee = new Coordonnee(abscisse, ordonnee);
        this.etatMachine = new Disponible();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    public EtatMachine getEtatMachine() {
        return etatMachine;
    }

    public void setEtatMachine(EtatMachine etatMachine) {
        this.etatMachine = etatMachine;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString(delimiter) + delimiter
                + this.type + delimiter
                + this.cout + delimiter
                + this.coordonnee;
    }

    @Override
    public double calculerCoutHoraire() {
        return getCout();
    }
}
