package INSA.TD.models;

import java.util.ArrayList;

public class Poste extends Equipement {
    private ArrayList<Machine> listeMachines;

    public Poste(ArrayList<Machine> listeMachines,
                 String dEquipement,
                 String refEquipement) {
        this.listeMachines = listeMachines;
        this.setProperties(dEquipement, refEquipement);
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public void setListeMachines(ArrayList<Machine> listeMachines) {
        this.listeMachines = listeMachines;
    }
}
