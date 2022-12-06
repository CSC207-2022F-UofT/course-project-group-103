package entities;


import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant extends Property {

    /**
     * Text of kitchen specifications as a string.
     */
    private final String kitchenSpecifications;

    /**
     * Constructor for restaurant subclass of property, assigns values to its attributes.
     *
     * @param name: Name of restaurant.
     * @param address: Address of restaurant.
     * @param ID: Unique ID for restaurant.
     * @param owner: Owner instance of the owner class.
     * @param sqFt: Square footage of restaurant.
     * @param price: Asking price of restaurant.
     * @param kitchenSpecifications: String of kitchen specifications.
     * @param bids: Hash map of bids on the condo with a User ID as key and float as bid amount.
     */
    public Restaurant(String name, String address, String ID, Owner owner, int sqFt,
                      float price, String kitchenSpecifications, HashMap<String, Float> bids){
        super(name, address, ID, owner, sqFt, price, bids);
        this.kitchenSpecifications = kitchenSpecifications;
    }

    /**
     * Returns the kitchen specifications.
     * @return string representation of kitchen specifications.
     */
    public String getKitchenSpecifications() {
        return this.kitchenSpecifications;
    }

    /**
     * Calls the implementation of info() in the superclass to get summary of non-unique attributes and then
     * adds unique attributes to the array list. ID and bids are not added to this array list.
     * @return Array List of formatted string representations of the restaurant attributes.
     */
    @Override
    public ArrayList<String> info() {
        ArrayList<String> info = super.info();
        info.add("Kitchen Specifications: " + this.getKitchenSpecifications());
        return info;
    }
}