package Properties;

public class Condo extends ResidentialProperty{
    private int parking;
    private int monthly_fees;
    private String amenities;

    public Condo(String name, String address, String ID, String owner, int sqFt, int price,
                 int kitchens, int bedrooms, int bathrooms, int laundry,
                 int parking, int monthly_fees, String amenities) {
        super(name, address, ID, owner, sqFt, price, kitchens, bedrooms, bathrooms, laundry);
        this.parking = parking;
        this.monthly_fees = monthly_fees;
        this.amenities = amenities;
    }

    public int getParking() {
        return parking;
    }

    public int getMonthly_fees() {
        return monthly_fees;
    }

    public String getAmenities() {
        return amenities;
    }
}
