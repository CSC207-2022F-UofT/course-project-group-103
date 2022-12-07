package interactors.containers;

import entities.Property;

public class PropertyToDisplay {

    private Property property;

    public void setPropertyDisplay(Property p) {
        this.property = p;
    }

    public Property getPropertyDisplay() {
        return this.property;
    }

}
