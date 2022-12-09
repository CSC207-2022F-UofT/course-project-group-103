package interactors;

import entities.*;

import java.util.ArrayList;

public class PropertyModel {

    /**
     * ID of the property.
     */
    String propertyID;
    /**
     * ID of the owner of the property.
     */
    String ownerID;
    /**
     * Type of the property.
     */
    String type;
    /**
     * Name of the property.
     */
    String name;
    /**
     * Address of the property.
     */
    String address;
    /**
     * Name of the owner.
     */
    String owner;
    /**
     * Sqaure footage of the property.
     */
    int sqft;
    /**
     * Price of the property.
     */
    float price;
    /**
     * Number of bedrooms of the property.
     */
    int numBed;
    /**
     * Number of bathrooms of the property.
     */
    int numBath;
    /**
     * Number of laundry rooms of the property.
     */
    int numLaundry;
    /**
     * Number of kitchens of the property.
     */
    int numKitchens;
    /**
     * Number of office rooms of the property.
     */
    int numOffice;
    /**
     * Number of receptions of the property.
     */
    int numReception;
    /**
     * Kitchen specifications of the property.
     */
    String spec;
    /**
     * Bids on the property.
     */
    ArrayList<BidModel> bids;

    /**
     * Constructor for the property model, assigns its attributes.
     *
     * @param p: property object to convert to property model
     * @param bids: array list of bid models of bids on the property
     */
    public PropertyModel(Property p, ArrayList<BidModel> bids) {
        this.bids = bids;
        this.propertyID = p.getID();
        this.ownerID = p.getOwner().getID();
        this.type = p.getType();
        this.name = p.getName();
        this.address = p.getAddress();
        this.owner = p.getOwner().getName();
        this.sqft = p.getSqFt();
        this.price = p.getPrice();
        if (p.getType().equals("House")) {
            this.numBed = ((House) p).getNumBedrooms();
            this.numBath = ((House) p).getNumBathrooms();
            this.numLaundry = ((House) p).getNumLaundry();
            this.numKitchens = ((House) p).getNumKitchen();
        }
        if (p.getType().equals("Condo")) {
            this.numBed = ((Condo) p).getNumBedrooms();
            this.numBath = ((Condo) p).getNumBathrooms();
            this.numLaundry = ((Condo) p).getNumLaundry();
            this.numKitchens = ((Condo) p).getNumKitchen();
        }
        if (p.getType().equals("Office")) {
            this.numOffice = ((Office) p).getNumOfficeRooms();
            this.numReception = ((Office) p).getNumReceptions();
        }
        if (p.getType().equals("Restaurant")) {
            this.spec = ((Restaurant) p).getKitchenSpecifications();
        }
    }

    /**
     * Gets the property id.
     * @return String representation of property id.
     */
    public String getPropertyID() {
        return this.propertyID;
    }

    /**
     * Gets the id of the owner.
     * @return String representation of property owner id.
     */
    public String getOwnerID() {
        return this.ownerID;
    }

    /**
     * Gets the name.
     * @return String representation of property name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the address.
     * @return String representation of property address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the owner name.
     * @return String representation of property owner's name.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Gets the square footage.
     * @return int representation of property square footage.
     */
    public int getSqFt() {
        return this.sqft;
    }

    /**
     * Gets the property price.
     * @return float representation of property price.
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Gets the number of bedrooms.
     * @return int representation of property's number of bedrooms.
     */
    public int getNumBed() {
        return this.numBed;
    }

    /**
     * Gets the number of bathrooms.
     * @return int representation of property's number of bathrooms.
     */
    public int getNumBath() {
        return this.numBath;
    }

    /**
     * Gets the number of laundry rooms.
     * @return int representation of property's number of laundry rooms.
     */
    public int getNumLaundry() {
        return this.numLaundry;
    }

    /**
     * Gets the number of kitchens.
     * @return int representation of property's number of kitchens.
     */
    public int getNumKitchens() {
        return this.numKitchens;
    }

    /**
     * Gets the number of office rooms.
     * @return int representation of property's number of office rooms.
     */
    public int getNumOffice() {
        return this.numOffice;
    }

    /**
     * Gets the number of receptions.
     * @return int representation of property's number of receptions.
     */
    public int getNumReception() {
        return this.numReception;
    }

    /**
     * Gets the kitchen specifications.
     * @return String representation of property's kitchen specifications.
     */
    public String getSpec() {
        return this.spec;
    }

    /**
     * Gets the property type.
     * @return String representation of property type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the bids.
     * @return array list of bid models, each a bid on the property.
     */
    public ArrayList<BidModel> getBids() {
        return this.bids;
    }
}
