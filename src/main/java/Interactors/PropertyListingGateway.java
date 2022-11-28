package Interactors;

import Properties.*;

// Use case layer
public interface PropertyListingGateway {
    /**
     * Saves a property object to the database.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    public void save(Property p);
}
