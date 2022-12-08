package interactors;

import entities.*;

import java.util.ArrayList;

public class PropertyModel {

    String propertyID;
    String ownerID;
    String type;
    String name;
    String address;
    String owner;
    int sqft;
    float price;
    int numBed;
    int numBath;
    int numLaundry;
    int numKitchens;
    int numOffice;
    int numReception;
    String spec;
    ArrayList<BidModel> bids;

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

    public String getPropertyID() {
        return this.propertyID;
    }

    public String getOwnerID() {
        return this.ownerID;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getSqFt() {
        return this.sqft;
    }

    public float getPrice() {
        return this.price;
    }

    public int getNumBed() {
        return this.numBed;
    }

    public int getNumBath() {
        return this.numBath;
    }

    public int getNumLaundry() {
        return this.numLaundry;
    }

    public int getNumKitchens() {
        return this.numKitchens;
    }

    public int getNumOffice() {
        return this.numOffice;
    }

    public int getNumReception() {
        return this.numReception;
    }

    public String getSpec() {
        return this.spec;
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<BidModel> getBids() {
        return this.bids;
    }
}
