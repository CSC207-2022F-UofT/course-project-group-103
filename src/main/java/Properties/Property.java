package Properties;

import Users.Owner;

public abstract class Property {

    private final String name;
    private final String address;
    private final String ID;

    private Owner owner;
    private final int sqFt;

    private float price;

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

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void markSold();

    public abstract void editProperty();

    public abstract void updateListing();
}
