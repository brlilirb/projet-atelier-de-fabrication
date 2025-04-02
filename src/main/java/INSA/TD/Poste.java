package INSA.TD;

import java.util.ArrayList;

public class Poste extends Equipement {
    private String refPoste;
    private String dPoste;
    private ArrayList<Machine> listeMachines;

    public Poste(String refPoste, String dPoste, ArrayList<Machine> listeMachines) {
        this.refPoste = refPoste;
        this.dPoste = dPoste;
        this.listeMachines = listeMachines;
    }

    public void modifierPoste(){
        double n;
        System.out.println("Que voulez-modifier ?");
        System.out.println("1: la référence");
        System.out.println("2: la description");
        System.out.println("3: la liste des machines");
        n = Lire.d();
    }

    public void afficherPoste(){
        System.out.println();
    }

    public String getRefPoste() {
        return refPoste;
    }

    public void setRefPoste(String refPoste) {
        this.refPoste = refPoste;
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public void setListeMachines(ArrayList<Machine> listeMachines) {
        this.listeMachines = listeMachines;
    }

    public String getdPoste() {
        return dPoste;
    }

    public void setdPoste(String dPoste) {
        this.dPoste = dPoste;
    }

}
