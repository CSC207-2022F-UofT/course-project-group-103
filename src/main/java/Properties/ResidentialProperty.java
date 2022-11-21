package Properties;

public abstract class ResidentialProperty extends Property {
    private int kitchens;
    private int bedrooms;
    private int bathrooms;
    private int laundry;

    public ResidentialProperty(String name, String address, String ID, String owner, int sqFt, int price,
                               int kitchens, int bedrooms, int bathrooms, int laundry) {
        super(name, address, ID, owner, sqFt, price);
        this.kitchens = kitchens;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.laundry = laundry;
    }

    public int getKitchens() {
        return kitchens;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getLaundry() {
        return laundry;
    }
}
