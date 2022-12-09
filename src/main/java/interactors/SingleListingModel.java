package interactors;

public class SingleListingModel {
    /**
     * ID of property associated with this listing.
     */
    String ID;
    /**
     * Address of property associated with this listing.
     */
    String address;
    /**
     * Price of property associated with this listing.
     */
    float price;

    /**
     * Constructor for a single listing model, assigns its attributes.
     *
     * @param id: ID of the property.
     * @param address: address of the property.
     * @param price: price of the property.
     */
    public SingleListingModel(String id, String address, float price) {
        this.ID = id;
        this.address = address;
        this.price = price;
    }

    /**
     * Gets the id of the property associated with this listing.
     * @return String representation of the id.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Gets the address of the property associated with this listing.
     * @return String representation of the address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the price of the property associated with this listing.
     * @return float representation of the price.
     */
    public float getPrice() {
        return this.price;
    }
}
