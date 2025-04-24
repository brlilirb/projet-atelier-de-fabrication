package INSA.TD.models;

public class Operation extends AbstractDescription {
    private String refEquipement;
    private float dureeOperation; //unite : heure

    public Operation(String refOperation,
                     String dOperation,
                     String refequipement,
                     float dureeOperation) {
        this.setProperties(dOperation, refOperation);
        this.refEquipement = refequipement;
        this.dureeOperation = dureeOperation;
    }

    public String getRefEquipement() {
        return refEquipement;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public float getDureeOperation() {
        return dureeOperation;
    }

    public void setDureeOperation(float dureeOperation) {
        this.dureeOperation = dureeOperation;
    }
}
