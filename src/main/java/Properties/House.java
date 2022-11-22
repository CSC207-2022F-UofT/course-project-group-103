package Properties;

import Users.Owner;

import java.util.ArrayList;

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
    public ArrayList<String> info() {
        ArrayList<String> info = super.info();
        info.add("Bedrooms: " + this.getNumBedrooms());
        info.add("Bathrooms: " + this.getNumBathrooms());
        info.add("Kitchens: " + this.getNumKitchen());
        info.add("Laundry: " + this.getNumLaundry());
        return info;
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