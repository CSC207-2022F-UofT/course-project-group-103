package entities;

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
}