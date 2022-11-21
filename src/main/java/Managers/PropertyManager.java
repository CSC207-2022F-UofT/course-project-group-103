package Managers;

import Properties.Property;

import java.util.ArrayList;

public class PropertyManager {

    private ArrayList<Property> properties;

    public PropertyManager() {
        properties = new ArrayList<Property>();
    }

    /**
     * Adds new property to the Arraylist
     * @param p - Given property to add
     * @return boolean if the addition was successful, or false if a Property with the identical ID
     *          already exists
     */
    public boolean addProperty(Property p) {
        if (properties.size() == 0) {
            properties.add(p);
        } else {
            for (int i = 0; i < properties.size(); i++)
                if (properties.get(i).getID() == p.getID()) {
                    return false;
                }
            properties.add(p);
        }
        return true;
    }

    /**
     * Removes given property based on ID
     * @param id - String identifier for each property
     * @return boolean indicating if the property has been removed
     */
    public boolean removeProperty (String id) {

        for (int i = 0; i < properties.size(); i++)
            if (properties.get(i).getID() == id) {
                properties.remove(i);
                return true;
            }
        return false;
    }

    /**
     * Edits given property based on id, replaces with a new Property object
     * @param id - String identifier for each property
     * @param p - Property replacing the outdated property
     * @return
     */
    public boolean editProperty (String id, Property p) {
        for (int i = 0; i < properties.size(); i++)
            if (properties.get(i).getID() == id) {
                properties.set(i, p);
                return true;
            }
        return false;
    }

    /**
     * Gets a given property based on the Property ID
     * @param id - String identifier for each property
     * @return Property located by the ID or null if the property was not inside the list
     */
    public Property getProperty (String id) {
        for (int i = 0; i < properties.size(); i++)
            if (properties.get(i).getID() == id) {
                return properties.get(i);
            }
        return null;
    }


}
