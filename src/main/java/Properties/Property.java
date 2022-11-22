package Properties;

import java.util.HashMap;
import java.util.ArrayList;
import Users.Owner;

public abstract class Property {

    protected final String name;
    protected final String address;
    protected final String ID;
    protected Owner owner;
    protected final int sqFt;
    protected float price;
    protected HashMap<String, Float> bids = new HashMap<>();

    // for now not adding bids to the constructor

    public Property(String name, String address, String ID, Owner owner, int sqFt, float price) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.owner = owner;
        this.sqFt = sqFt;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getID() {
        return ID;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getSqFt() {
        return sqFt;
    }

    public float getPrice() {
        return price;
    }

    public String getType() {return this.getClass().getName();}

    public HashMap<String, Float> getBids() {
        return this.bids;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addBid(float bid, String user) {bids.put(user, bid);}

    public ArrayList<String> info() {
        // Subclasses should override this method and add any subclass unique attributes
        // that should be displayed to this arraylist.
        ArrayList<String> info = new ArrayList<>();
        info.add("Type: " + this.getType());
        info.add("Name: " + this.getName());
        info.add("Address: " + this.getAddress());
        info.add("Owner: " + this.getOwner());
        info.add("SqFt: " + this.getSqFt());
        info.add("Price: " + this.getPrice());
        return info;

    }

    public abstract void markSold();

    public abstract void editProperty();

    public abstract void updateListing();
}