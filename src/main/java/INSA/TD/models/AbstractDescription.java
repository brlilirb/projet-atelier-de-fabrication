package INSA.TD.models;

import INSA.TD.utils.ConstantesUtils;

public abstract class AbstractDescription extends AbstractIdentity {

    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setProperties(String designation, String id) {
        this.designation = designation;
        this.setId(id);
    }

    @Override
    public String toString() {
        return toString(ConstantesUtils.SPACE);
    }

    public String toString(String delimiter) {
        return super.toString() + delimiter
                + designation;
    }


}
