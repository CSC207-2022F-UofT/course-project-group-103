package entities;

import java.util.HashMap;

public class Office extends Property{

    /**
     * Number of office rooms in office.
     */
    private final int numOfficeRooms;
    /**
     * Number of receptions in office.
     */
    private final int numReceptions;

    /**
     * Constructor for office subclass of property, assigns values to its attributes.
     *
     * @param name: Name of office.
     * @param address: Address of office.
     * @param ID: Unique ID for office.
     * @param owner: Owner instance of the owner class.
     * @param sqFt: Square footage of office.
     * @param price: Asking price of office.
     * @param numOfficeRooms: Number of bedrooms in office.
     * @param numReceptions: Number of bathrooms in office.
     * @param bids: Hash map of bids on the condo with a User ID as key and float as bid amount.
     */
    public Office(String name, String address, String ID, Owner owner, int sqFt,
                  float price, int numOfficeRooms, int numReceptions, HashMap<String, Float> bids) {
        super(name, address, ID, owner, sqFt, price, bids);
        this.numOfficeRooms = numOfficeRooms;
        this.numReceptions = numReceptions;
    }

    /**
     * Returns number of office rooms in office.
     * @return integer number of office rooms.
     */
    public int getNumOfficeRooms() {
        return this.numOfficeRooms;
    }

    /**
     * Returns number of receptions in office.
     * @return integer number of receptions.
     */
    public int getNumReceptions() {
        return this.numReceptions;
    }
}

