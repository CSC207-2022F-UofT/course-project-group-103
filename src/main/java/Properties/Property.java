package Properties;

import java.util.HashMap;
import java.util.ArrayList;

public abstract class Property {

    private String name;
    private String address;
    private String ID;
    private String owner;
    private int sqFt;
    private float price;
    private HashMap<String, Float> bids = new HashMap<>();

    public Property(String name, String address, String ID, String owner, int sqFt, float price) {
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

    public String getOwner() {
        return owner;
    }

    public int getSqFt() {
        return sqFt;
    }

    public float getPrice() {
        return price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addBid(float bid, String user) {bids.put(user, bid);}

    public String getType() {return this.getClass().getName();}

    public ArrayList<String> info() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Type: " + this.getType());
        info.add("Name: " + this.getName());
        info.add("Address: " + this.getAddress());
        info.add("Owner: " + this.getOwner());
        info.add("SqFt: " + this.getSqFt());
        info.add("Price: " + this.getPrice());
        return info;

    }

    //public abstract void markSold();

    //public abstract void editProperty();

    //public abstract void updateListing();
}
