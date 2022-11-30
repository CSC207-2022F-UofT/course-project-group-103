package Properties;


import Users.Owner;

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
    public void getSold() {

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