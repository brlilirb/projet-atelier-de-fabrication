package INSA.TD.models;

import INSA.TD.utils.StringUtils;

public abstract class AbstractIdentity {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = StringUtils.escapeSpaces(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
