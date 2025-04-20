package INSA.TD.models;

public class Machine extends Equipement {
    private String type;
    private float cout;
    private Coordonnee coordonnee;

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

    @Override
    public String toString() {
        return toString(" ");
    }

    public String toString(String delimiter) {
        return super.toString(delimiter) + delimiter
                + this.type + delimiter
                + this.cout + delimiter
                + this.coordonnee;
    }
}
