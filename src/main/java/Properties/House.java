package Properties;

public class House extends ResidentialProperty {

    private int backyard;
    private int basement;
    public House(String name, String address, String ID, String owner, int sqFt, int price,
                 int kitchens, int bedrooms, int bathrooms, int laundry,
                 int backyard, int basement) {
        super(name, address, ID, owner, sqFt, price, kitchens, bedrooms, bathrooms, laundry);
        this.backyard = backyard;
        this.basement = basement;
    }

    public int getBackyard() {
        return backyard;
    }

    public int getBasement() {
        return basement;
    }
}
