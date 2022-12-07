package interactors;

import entities.*;
import interactors.containers.AccountToDisplay;
import interactors.containers.ActiveUser;
import interactors.containers.PropertyToDisplay;
import interactors.gateway_interfaces.PropertyGateway;

import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.HashMap;

public class PropertyInteractor {
    /**
     * Current property being accessed.
     */
    PropertyToDisplay propertyToDisplay;
    /**
     * Current active user of the application.
     */
    ActiveUser activeUser;
    /**
     * Current account being accessed.
     */
    AccountToDisplay accountToDisplay;
    /**
     * Gateway interface to property JSON with read/write methods.
     */
    PropertyGateway propertyGateway;

    /**
     * Constructor for the property interactor, assigns object instances to its attributes.
     *
     * @param p: PropertyToDisplay class for this application instance's current accessed property.
     * @param user: ActiveUser class for this application instance's current active user.
     * @param a: AccountToDisplay class for this application instance's current accessed account.
     * @param g: implementation of propertyGateway interface.
     */
    public PropertyInteractor(PropertyToDisplay p, ActiveUser user, AccountToDisplay a, PropertyGateway g) {
        this.propertyToDisplay = p;
        this.activeUser = user;
        this.accountToDisplay = a;
        this.propertyGateway = g;
    }

    /**
     * Checks whether the active user is the owner of the currently accessed property.
     * @return boolean of whether active user is owner.
     */
    public boolean checkOwner() {
        if (this.activeUser.getActiveUser()!=null) {
            return this.propertyToDisplay.getPropertyDisplay().getOwner().getID().equals(
                    this.activeUser.getActiveUser().getID());
        }
        return false;
    }

    /**
     * Returns an Array List of all relevant attributes of a property.
     * @return Array List of formatted string representations of the property attributes.
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
     * Checks if the bid is valid (if it is an integer and above 10% of the asking price), and then sends the bid to the
     * database.
     *
     * @param bid: String representing the chosen bid amount.
     * @throws Exception: failed to send bid.
     */
    public void sendBid(String bid) throws Exception {
        try {
            Property p = this.propertyToDisplay.getPropertyDisplay();
            double minBid = p.getPrice() * 0.1;
            if (Float.parseFloat(bid) >= minBid) {
                p.addBid(Float.parseFloat(bid), this.activeUser.getActiveUser().getID());
                this.propertyGateway.save(p);
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

    /**
     * Creates an array list of single listing bid interactors for bids on the current property to be
     * passed to the presenter.
     * @return array list of SingleBidInteractors
     */
    public ArrayList<SingleBidInteractor> createBids() {
        HashMap<String, Float> bids = this.propertyToDisplay.getPropertyDisplay().getBids();
        ArrayList<SingleBidInteractor> interactors = new ArrayList<>();
        for (String s: bids.keySet()) {
            try {
                interactors.add(new SingleBidInteractor(this.propertyGateway.getUser(s),
                        bids.get(s), accountToDisplay));
            } catch(Exception e) {return null;}
        }
        return interactors;
    }

    /**
     * Deletes the currently accessed property if the active user is the owner and the password matches.
     * @throws Exception: failed to delete.
     */
    public void deleteProperty(String password) throws Exception {
        if (!this.activeUser.getActiveUser().getPassword().equals(password)) {
            throw new Exception("Incorrect Password.");
        }
        this.propertyGateway.removePropertyById(this.propertyToDisplay.getPropertyDisplay().getID());
    }

    /**
     * Updates the currently accessed account to the property owner's account.
     */
    public void updateAccountToDisplay() {
        this.accountToDisplay.setAccountDisplay(this.propertyToDisplay.getPropertyDisplay().getOwner());
    }
}
