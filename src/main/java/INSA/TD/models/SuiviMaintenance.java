package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.TimeUtils;

import java.time.LocalDateTime;

public class SuiviMaintenance {

    private Long id;

    private final String date;

    private final String time;

    private final String refMachine;

    private final String etat; // "A" ou "D"

    private final String operateur;

    private final String cause;

    public SuiviMaintenance(String[] args) {
        this.date = args[0];
        this.time = args[1];
        this.refMachine = args[2];
        this.etat = args[3].toUpperCase();
        this.operateur = args[4];
        this.cause = args[5].toLowerCase();
    }

    public SuiviMaintenance(Long id, String date, String time, String refMachine, String etat, String operateur, String cause) {
        this(
                date,
                time,
                refMachine,
                etat,
                operateur,
                cause
        );
        setId(id);
    }

    public SuiviMaintenance(String date, String time, String refMachine, String etat, String operateur, String cause) {
        this.date = date;
        this.time = time;
        this.refMachine = refMachine;
        this.etat = etat;
        this.operateur = operateur;
        this.cause = cause;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOperateur() {
        return operateur;
    }

    public String getCause() {
        return cause;
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return date + delimiter +
                time + delimiter +
                refMachine + delimiter +
                etat + delimiter +
                operateur + delimiter +
                cause;
    }
}
