package Properties;

import Users.Owner;

public class House extends Property {

    private final int numBedrooms;
    private final int numBathrooms;
    private final int numLaundry;
    private final int numKitchen;
    public House(String name, String address, String ID, Owner owner, int sqFt,
                 float price, int numBedrooms, int numBathrooms, int numLaundry, int numKitchen) {
        super(name, address, ID, owner, sqFt, price);
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.numLaundry = numLaundry;
        this.numKitchen = numKitchen;
    }

    public int getNumLaundry() {
        return numLaundry;
    }

    public int getNumKitchen() {
        return numKitchen;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
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
