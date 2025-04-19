package INSA.TD.models;

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
}
