package interactors;

import entities.*;
import interactors.containers.AccountToDisplay;
import interactors.containers.ActiveUser;
import interactors.containers.PropertyToDisplay;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.HashMap;

public class PropertyInteractor {
    /**
     * Currently it's assumed that the Property, User, and PropertyListingManager
     * objects already exist by the time a PropertyPageInteractor object is created.
     */
    PropertyToDisplay propertyToDisplay;
    ActiveUser activeUser;
    AccountToDisplay accountToDisplay;
    PropertyListingGateway propertyListingGateway;

    public PropertyInteractor(PropertyToDisplay p, ActiveUser user, AccountToDisplay a, PropertyListingGateway g) {
        this.propertyToDisplay = p;
        this.activeUser = user;
        this.accountToDisplay = a;
        this.propertyListingGateway = g;
    }

    public boolean checkOwner() {
        if (this.activeUser.getActiveUser()!=null) {
            return this.propertyToDisplay.getPropertyDisplay().getOwner().getID().equals(
                    this.activeUser.getActiveUser().getID());
        }
        return false;
    }

    /**
     * Returns an Array List of all relevant attributes of a property.
     *
     * Goes through each get method of the property object adding all results to an Array List, it ignores the bids,
     * ID, and class attribute as these should not be displayed to users.
     *
     */
    public ArrayList<String> propertyInfo() {
        if (this.propertyToDisplay.getPropertyDisplay()!=null) {
            return this.propertyToDisplay.getPropertyDisplay().info();
        }
        ArrayList<String> empty = new ArrayList<>();
        empty.add("error");
        return empty;
    }

    /**
     * Sends the given bid to the database.
     *
     * Checks if the mid is valid (if it is an integer and above 10% of the asking price), and then sends the bid to the
     * database. If bid is too low throws an Offer to low exception, if bid is not able to be parsed to string it throws
     * an invalid bid exception.
     *
     * @param bid: String representing the chosen bid amount.
     */
    public void sendBid(String bid) throws Exception {
        try {
            Property p = this.propertyToDisplay.getPropertyDisplay();
            double minBid = p.getPrice() * 0.1;
            if (Float.parseFloat(bid) >= minBid) {
                p.addBid(Float.parseFloat(bid), this.activeUser.getActiveUser().getID());
                this.propertyListingGateway.save(p);
            } else {
                throw new Exception("Offer too low. Please offer at least 10% of asking price.");
            }
        } catch(Exception e) {
            if (e instanceof NumberFormatException) {
                throw new Exception("Invalid offer.");
            }
            throw e;
        }
    }

    public ArrayList<SingleBidInteractor> createBids() {
        HashMap<String, Float> bids = this.propertyToDisplay.getPropertyDisplay().getBids();
        ArrayList<SingleBidInteractor> interactors = new ArrayList<>();
        for (String s: bids.keySet()) {
            try {
                interactors.add(new SingleBidInteractor(this.propertyListingGateway.getUser(s),
                        bids.get(s), accountToDisplay));
            } catch(Exception e) {return null;}
        }
        return interactors;
    }
}
