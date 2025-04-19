package INSA.TD.models;

public abstract class AbstractIdentity {

    private String reference;
    private String designation;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setProperties(String designation, String reference) {
        this.designation = designation;
        this.reference = reference;
    }

}
