package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.ListUtils;

import java.util.List;

public class Poste extends Equipement {
    private List<Machine> listeMachines;

    public Poste() {
    }

    public Poste(List<Machine> listeMachines,
                 String dEquipement,
                 String refEquipement) {
        this.listeMachines = listeMachines;
        this.setProperties(dEquipement, refEquipement);
    }

    public List<Machine> getListeMachines() {
        return listeMachines;
    }

    public void setListeMachines(List<Machine> listeMachines) {
        this.listeMachines = listeMachines;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString(delimiter) + delimiter
                + ListUtils.listToString(listeMachines);
    }

    @Override
    public double calculerCoutHoraire() {
        return listeMachines.stream()
                .mapToDouble(Machine::getCout)
                .sum();
    }
}
