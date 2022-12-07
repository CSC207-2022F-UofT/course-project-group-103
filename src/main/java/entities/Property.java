package entities;

import java.util.HashMap;
import java.util.ArrayList;

public abstract class Property {

    /**
     * Name of property.
     */
    protected final String name;
    /**
     * Address of property.
     */
    protected final String address;
    /**
     * Unique ID of property.
     */
    protected final String ID;
    /**
     * Owner class instance for the owner of the property.
     */
    protected Owner owner;
    /**
     * Square footage of property.
     */
    protected final int sqFt;
    /**
     * Asking price of property.
     */
    protected float price;
    /**
     * Bids on the property with the string key as the user ID who sent the bid
     * and the float as the value of the bid.
     */
    protected HashMap<String, Float> bids;

    /**
     * Constructor for property class, assigns values to its attributes.
     *
     * @param name: Name of property.
     * @param address: Address of property.
     * @param ID: Unique ID for property.
     * @param owner: Owner instance of the owner class.
     * @param sqFt: Square footage of property.
     * @param price: Asking price of property.
     * @param bids: Hash map of bids on the condo with a User ID as key and float as bid amount.
     */
    public Property(String name, String address, String ID, Owner owner, int sqFt, float price, HashMap<String,Float> bids) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.owner = owner;
        this.sqFt = sqFt;
        this.price = price;
        this.bids = bids;
    }

    /**
     * Returns the name of the property.
     * @return string representation of property name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the property.
     * @return string representation of property address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the ID of the property.
     * @return string representation of property ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the owner of the property.
     * @return owner class of property owner.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Returns the square footage of the property.
     * @return integer representation of property square footage.
     */
    public int getSqFt() {
        return sqFt;
    }

    /**
     * Returns the asking price of the property.
     * @return float representation of property asking price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the class type of the property, this is useful when called from a subclass.
     * @return string representation of property class type.
     */
    public String getType() {return this.getClass().getName().replace("entities.", "");}

    /**
     * Returns the bids on the property.
     * @return hash map representation of bids with string as bidder ID and float as bid amount.
     */
    public HashMap<String, Float> getBids() {
        return this.bids;
    }

    /**
     * Adds a bid on the property.
     * @param bid: float representation of bid amount.
     * @param user: ID of user who placed the bid.
     */
    public void addBid(float bid, String user) {bids.put(user, bid);}

    /**
     * Removes the bid associated with the user id.
     * @param userID: removeBid.
     */
    public void removeBid(String userID) {
        this.bids.remove(userID);
    }

    /**
     * Creates an array list of strings and adds all attributes apart from ID and bids
     * to the list in string form preceded by a label of the attribute.
     * @return Array List of formatted string representations of the property attributes.
     */
    public ArrayList<String> info() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Type: " + this.getType());
        info.add("Name: " + this.getName());
        info.add("Address: " + this.getAddress());
        info.add("Owner: " + this.getOwner().getName());
        info.add("SqFt: " + this.getSqFt());
        info.add("Price: " + this.getPrice());
        return info;

    }
}