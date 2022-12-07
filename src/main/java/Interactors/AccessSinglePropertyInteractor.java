package Interactors;

import Exceptions.UndefinedPropertyType;
import Managers.PropertyManager;
import Properties.Property;

public class AccessSinglePropertyInteractor {
    String property_id;

    public AccessSinglePropertyInteractor(String property_id) {
        this.property_id = property_id;
    }

    public Property access_single_property() throws UndefinedPropertyType {
        return PropertyManager.getProperty(this.property_id);
    }
}
