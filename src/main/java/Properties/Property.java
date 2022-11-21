package Properties;

public abstract class Property {

    protected String name;
    protected String address;
    protected String ID;

    protected String owner;
    protected int sqFt;
    protected int price;

    public Property(String name, String address, String ID, String owner, int sqFt, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void markSold();

    public abstract void editProperty();

    public abstract void updateListing();
}
