package INSA.TD.services.implementation;

public class SuiviMaintenance {

    private final String date;

    private final String time;

    private final String refMachine;

    private final String marche;
    // ... Others fields


    public SuiviMaintenance(String[] args) {
        this.date = args[0];
        this.time = args[1];
        this.refMachine = args[2];
        this.marche = args[3];
        // ... other fields
    }

    public String getDate() {
        return date;
    }

    public String getRefMachine() {
        return refMachine;
    }

    public String getTime() {
        return time;
    }

    public String getMarche() {
        return marche;
    }
}
