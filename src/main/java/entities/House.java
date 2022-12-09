package entities;

import java.util.HashMap;

public class House extends Property {

    /**
     * Number of bedrooms in house.
     */
    private final int numBedrooms;
    /**
     * Number of bathrooms in house.
     */
    private final int numBathrooms;
    /**
     * Number of laundry rooms in house.
     */
    private final int numLaundry;
    /**
     * Number of kitchens in house.
     */
    private final int numKitchen;

    /**
     * Constructor for house subclass of property, assigns values to its attributes.
     *
     * @param name: Name of house.
     * @param address: Address of house.
     * @param ID: Unique ID for house.
     * @param owner: Owner instance of the owner class.
     * @param sqFt: Square footage of house.
     * @param price: Asking price of house.
     * @param numBedrooms: Number of bedrooms in house.
     * @param numBathrooms: Number of bathrooms in house.
     * @param numLaundry: Number of laundry rooms in house.
     * @param numKitchen: Number of kitchen rooms in house.
     * @param bids: Hash map of bids on the condo with a User ID as key and float as bid amount.
     */
    public House(String name, String address, String ID, Owner owner, int sqFt,
                 float price, int numBedrooms, int numBathrooms, int numLaundry,
                 int numKitchen, HashMap<String, Float> bids) {
        super(name, address, ID, owner, sqFt, price, bids);
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.numLaundry = numLaundry;
        this.numKitchen = numKitchen;
    }

    /**
     * Returns number of laundry rooms in the house.
     * @return integer number of laundry rooms.
     */
    public int getNumLaundry() {
        return numLaundry;
    }

    /**
     * Returns number of kitchens in the house.
     * @return integer number of kitchens.
     */
    public int getNumKitchen() {
        return numKitchen;
    }

    /**
     * Returns number of bedrooms in the house.
     * @return integer number of bedrooms.
     */
    public int getNumBedrooms() {
        return numBedrooms;
    }

    /**
     * Returns number of bathrooms in house.
     * @return integer number of bathrooms.
     */
    public int getNumBathrooms() {
        return numBathrooms;
    }
}

