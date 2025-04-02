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
        int n;
        System.out.println("Que voulez-modifier ?");
        System.out.println("1: la référence");
        System.out.println("2: la description");
        System.out.println("3: la liste des machines");
        System.out.println("0: pour revenir en arrière");
        n = Lire.i();
        switch (n){
            case 1 : {
                System.out.println("Donnez la nouvelle référence");
                this.refPoste = Lire.S();
                break;
            }
            case 2 : {
                System.out.println("Donnez la nouvelle description");
                this.dPoste = Lire.S();
                break;
            }
            case 3 : {
                System.out.println("Voulez-vous :");
                System.out.println("1 : ajouter une machine");
                System.out.println("2 : supprimer une machine");
                n=Lire.i();
                switch(n){
                    case 1:{
                        System.out.print("Quel machine voulez-vous ajoutez?");
                        //listeMachines.add(Lire.Machine());
                        break;
                    }
                    case 2: {
                        System.out.println("Quel machine voulez-vous retirer?");
                            //
                        break;
                    }
                }
                break;
            }
        }
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
