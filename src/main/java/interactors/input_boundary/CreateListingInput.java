package interactors.input_boundary;

public interface CreateListingInput {
    void createHouse(String name, String address, String sqFt, String price, String numBed,
                     String numBath, String numLaundry, String numKitchen, String userID);
    void createCondo(String name, String address, String sqFt, String price, String numBed,
                     String numBath, String numLaundry, String numKitchen, String userID);
    void createOffice(String name, String address, String sqFt, String price, String numOffice,
                      String numReception, String userID);
    void createRestaurant(String name, String address, String sqFt, String price,
                          String spec, String userID);
}
