package Properties;

public class Restaurant extends CommercialProperty {
    private String specifications;
    public Restaurant (String name, String address, String ID, String owner, int sqFt, int price,
                   int land_size,
                   int office_rooms, int reception,
                       String specifications) {
        super(name, address, ID, owner, sqFt, price, land_size);
        this.specifications = specifications;
    }

    public String getSpecifications() {
        return specifications;
    }
}

