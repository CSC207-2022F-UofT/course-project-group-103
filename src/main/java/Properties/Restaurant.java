package Properties;


import Users.Owner;
import java.util.ArrayList;

public class Restaurant extends Property {

    private final String kitchenSpecifications;

    public Restaurant(String name, String address, String ID, Owner owner, int sqFt,
                      float price, String kitchenSpecifications){
        super(name, address, ID, owner, sqFt, price);
        this.kitchenSpecifications = kitchenSpecifications;
    }

    public String getKitchenSpecifications() {
        return this.kitchenSpecifications;
    }

    @Override
    public ArrayList<String> info() {
        ArrayList<String> info = super.info();
        info.add("Kitchen Specifications: " + this.getKitchenSpecifications());
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