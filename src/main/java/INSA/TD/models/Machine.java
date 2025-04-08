package INSA.TD.models;

public class Machine extends Equipement {
    private String type;
    private float cout;
    private float abscisse;
    private float ordonnee;

    public Machine(String type,
                   float ordonnee,
                   float abscisse,
                   float cout,
                   String dEquipement,
                   String refEquipement) {
        this.type = type;
        this.ordonnee = ordonnee;
        this.abscisse = abscisse;
        this.cout = cout;
        this.setEquipementProperties(dEquipement, refEquipement);
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
}
