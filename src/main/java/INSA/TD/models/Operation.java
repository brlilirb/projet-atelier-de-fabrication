package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;

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

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString(delimiter) + delimiter
                + refEquipement + delimiter
                + dureeOperation;
    }
}
