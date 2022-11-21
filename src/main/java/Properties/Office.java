package Properties;

public class Office extends CommercialProperty {

    private final int office_rooms;
    private final int reception;
    public Office (String name, String address, String ID, String owner, int sqFt, int price,
                   int land_size,
                   int office_rooms, int reception) {
        super(name, address, ID, owner, sqFt, price, land_size);
        this.office_rooms = office_rooms;
        this.reception = reception;
    }

    public int getOffice_rooms() {
        return office_rooms;
    }

    public int getReception() {
        return reception;
    }
}
