package Properties;

public class CommercialProperty extends Property{
    private int land_size;
    public CommercialProperty(String name, String address, String ID, String owner, int sqFt, int price,
                              int land_size) {
        super(name, address, ID, owner, sqFt, price);
        this.land_size = land_size;
    }

    public int getLand_size() {
        return land_size;
    }

    public void editProperty() {

    };

    public void updateListing() {

    };
}
