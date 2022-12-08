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
    ArrayList<Property> getProperties();
    void removePropertyById(String id);

}

