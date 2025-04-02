package INSA.TD;

import java.util.ArrayList;

public class Gamme {
    private String refGamme;
    private ArrayList<Operation> listeOperations = new ArrayList<>();
    private ArrayList<Equipement> listeEquipements = new ArrayList<>();

    public Gamme (String ref, ArrayList<Operation> ope, ArrayList<Equipement> equipement){
    ref=this.refGamme;
    ope=this.listeOperations;
    equipement=this.listeEquipements;
    }

    public String getRefGamme() {
        return refGamme;
    }

    public void setRefGamme(String refGamme) {
        this.refGamme = refGamme;
    }

    public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }

    public ArrayList<Equipement> getListeEquipements() {
        return listeEquipements;
    }

    public void setListeEquipements(ArrayList<Equipement> listeEquipements) {
        this.listeEquipements = listeEquipements;
    }
}
