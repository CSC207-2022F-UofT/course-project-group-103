package Properties;

import Users.Owner;

import java.util.ArrayList;

public class Office extends Property{

    private final int numOfficeRooms;
    private final int numReceptions;

    public Office(String name, String address, String ID, Owner owner, int sqFt,
                  float price, int numOfficeRooms, int numReceptions) {
        super(name, address, ID, owner, sqFt, price);
        this.numOfficeRooms = numOfficeRooms;
        this.numReceptions = numReceptions;
    }

    public int getNumOfficeRooms() {
        return this.numOfficeRooms;
    }

    public int getNumReceptions() {
        return this.numReceptions;
    }

    @Override
    public ArrayList<String> info() {
        ArrayList<String> info = super.info();
        info.add("Office Rooms: " + this.getNumOfficeRooms());
        info.add("Receptions: : " + this.getNumReceptions());
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