package Properties;

import Users.Owner;

public class Condo extends Property{

    private final int numBedrooms;
    private final int numBathrooms;
    private final int numLaundry;
    private final int numKitchen;
    public Condo(String name, String address, String ID, Owner owner, int sqFt,
                 float price, int numBedrooms, int numBathrooms, int numLaundry, int numKitchen) {
        super(name, address, ID, owner, sqFt, price);
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.numLaundry = numLaundry;
        this.numKitchen = numKitchen;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumKitchen() {
        return numKitchen;
    }

    public int getNumLaundry() {
        return numLaundry;
    }

    @Override
    public void markSold() {

    }

    @Override
    public void editProperty() {

    }

    @Override
    public void updateListing() {

    }
}
