package Interactors;

import Properties.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class PropertyPageInteractor {
    /**
     * Currently it's assumed that the Property, User, and PropertyListingManager
     * objects already exist by the time a PropertyPageInteractor object is created.
     */
    Property p;
    // In final version this should probably be a User object, but it is currently not implemented.
    String user;
    PropertyListingGateway propertyListingGateway;

    public PropertyPageInteractor(Property p, String user, PropertyListingGateway g) {
        this.p = p;
        this.user = user;
        this.propertyListingGateway = g;
    }

    /**
     * Returns an Array List of all relevant attributes of a property.
     *
     * Goes through each get method of the property object adding all results to an Array List, it ignores the bids,
     * ID, and class attribute as these should not be displayed to users.
     *
     */
    public ArrayList<String> propertyInfo() {
        return this.p.info();
    }

    /**
     * Sends the given bid to the database.
     *
     * Checks if the bid is valid (if it is an integer and above 10% of the asking price), and then sends the bid to the
     * database. If bid is too low throws an Offer to low exception, if bid is not able to be parsed to string it throws
     * an invalid bid exception.
     *
     * @param bid: String representing the chosen bid amount.
     */
    public void sendBid(String bid) throws Exception {
        try {
            double minBid = p.getPrice() * 0.1;
            if (Float.parseFloat(bid) >= minBid) {
                p.addBid(Float.parseFloat(bid), this.user);
                this.propertyListingGateway.save(p);
            } else {
                throw new Exception("Offer too low. Please offer at least 10% of asking price.");
            }
        } catch(Exception e) {
            if (e.getMessage().equals("Offer too low. Please offer at least 10% of asking price.")) {
                throw e;
            }
            throw new Exception("Invalid offer.");
        }
    }
}
