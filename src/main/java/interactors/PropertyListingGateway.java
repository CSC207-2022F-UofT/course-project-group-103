package interactors;

import entities.*;

import java.io.IOException;
import java.util.ArrayList;

// Use case layer
public interface PropertyListingGateway {
    /**
     * Saves a property object to the database.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    void save(Property p) throws Exception;
    ArrayList<Property> getProperties();
    User getUser(String ID) throws IOException, UndefinedUserType;
}

