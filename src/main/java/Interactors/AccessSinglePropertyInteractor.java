package Interactors;

import Exceptions.UndefinedPropertyType;
import Managers.PropertyManager;
import Properties.Property;

public class AccessSinglePropertyInteractor {
    public static void main(String[] args) throws UndefinedPropertyType {
        Property property = PropertyManager.getProperty("0");
        System.out.println(property.getAddress());

    }

    public static Property access_single_property(String property_id) throws UndefinedPropertyType {
        return PropertyManager.getProperty(property_id);
    }
}
