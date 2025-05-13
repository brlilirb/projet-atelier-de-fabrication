package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.TimeUtils;

import java.time.LocalDateTime;

public class SuiviMaintenance {

    private final String date;

    private final String time;

    private final String refMachine;

    private final String etat; // "A" ou "D"
    //TODO utiliser enum etatInterne et etatExterne ? boolean ?

    // ... Others fields

    public SuiviMaintenance(String[] args) {
        this.date = args[0];
        this.time = args[1];
        this.refMachine = args[2];
        this.etat = args[3];
        // ... other fields
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public LocalDateTime getDateTime() {
        return TimeUtils.convertStringToLocalDateTime(date + " " + time);
    }

    public String getRefMachine() {
        return refMachine;
    }

    public String getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return date + delimiter +
                time + delimiter +
                refMachine + delimiter +
                etat;
    }
}
