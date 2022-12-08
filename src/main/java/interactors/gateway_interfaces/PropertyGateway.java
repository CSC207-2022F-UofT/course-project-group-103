package interactors.gateway_interfaces;

import entities.*;
import interactors.exceptions.UndefinedUserType;
import java.io.IOException;
import java.util.ArrayList;

// Use case layer
public interface PropertyGateway {
    /**
     * Saves a property object to the database.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    void save(Property p) throws Exception;
    /**
     * Gets a list of all properties from the database.
     * @return Array list of property objects.
     */
    ArrayList<Property> getProperties();
    /**
     * Gets the user associated with an ID.
     * @return User object of user with the given ID.
     *
     * @param ID: ID of user to get.
     */
    User getUser(String ID) throws IOException, UndefinedUserType;
    /**
     * Removes the property with the given ID from the database.
     *
     * @param id: ID of property to remove.
     */
    void removePropertyById(String id);

}

