package entities;

import java.util.HashMap;

public class Condo extends Property {

    /**
     * Number of bedrooms in condo.
     */
    private final int numBedrooms;
    /**
     * Number of bathrooms in condo.
     */
    private final int numBathrooms;
    /**
     * Number of laundry rooms in condo.
     */
    private final int numLaundry;
    /**
     * Number of kitchens in condo.
     */
    private final int numKitchen;

    /**
     * Constructor for Condo subclass of property, assigns values to attributes.
     *
     * @param name: Name of condo.
     * @param address: Address of condo.
     * @param ID: Unique ID for condo.
     * @param owner: Owner instance of the owner class.
     * @param sqFt: Square footage of condo.
     * @param price: Asking price of condo.
     * @param numBedrooms: Number of bedrooms in condo.
     * @param numBathrooms: Number of bathrooms in condo.
     * @param numLaundry: Number of laundry rooms in condo.
     * @param numKitchen: Number of kitchen rooms in condo.
     * @param bids: Hash map of bids on the condo with a User ID as key and float as bid amount.
     */
    public Condo(String name, String address, String ID, Owner owner, int sqFt,
                 float price, int numBedrooms, int numBathrooms,
                 int numLaundry, int numKitchen, HashMap<String, Float> bids) {
        super(name, address, ID, owner, sqFt, price, bids);
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.numLaundry = numLaundry;
        this.numKitchen = numKitchen;
    }

    /**
     * Returns number of bathrooms in the condo.
     * @return integer of bathrooms.
     */
    public int getNumBathrooms() {
        return numBathrooms;
    }

    /**
     * Returns number of bedrooms in the condo.
     * @return integer number of bedrooms.
     */
    public int getNumBedrooms() {
        return numBedrooms;
    }

    /**
     * Returns number of kitchens in the condo.
     * @return integer number of kitchens.
     */
    public int getNumKitchen() {
        return numKitchen;
    }

    /**
     * Returns number of laundry rooms in the condo.
     * @return integer number of laundry rooms.
     */
    public int getNumLaundry() {
        return numLaundry;
    }
}
