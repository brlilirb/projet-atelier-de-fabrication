package INSA.TD.models;

public class Operation {
    private String refOperation;
    private String dOperation;
    private String refequipement;
    private float dureeOperation; //unite : heure

    public Operation(String refOperation,
                     String dOperation,
                     String refequipement,
                     float dureeOperation) {
        this.refOperation = refOperation;
        this.dOperation = dOperation;
        this.refequipement = refequipement;
        this.dureeOperation = dureeOperation;
    }

    public String getRefOperation() {
        return refOperation;
    }

    public void setRefOperation(String refOperation) {
        this.refOperation = refOperation;
    }

    public String getdOperation() {
        return dOperation;
    }

    public void setdOperation(String dOperation) {
        this.dOperation = dOperation;
    }

    public String getRefequipement() {
        return refequipement;
    }

    public void setRefequipement(String refequipement) {
        this.refequipement = refequipement;
    }

    public float getDureeOperation() {
        return dureeOperation;
    }

    public void setDureeOperation(float dureeOperation) {
        this.dureeOperation = dureeOperation;
    }
}
