package interactors;

public class SingleListingModel {
    String ID;
    String address;
    float price;

    public SingleListingModel(String id, String address, float price) {
        this.ID = id;
        this.address = address;
        this.price = price;
    }

    public String getID() {
        return this.ID;
    }

    public String getAddress() {
        return this.address;
    }

    public float getPrice() {
        return this.price;
    }
}
