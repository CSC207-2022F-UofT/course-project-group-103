package interactors.input_boundary;

public interface CreateListingInput {
    /**
     * Creates a house object.
     *
     * @param name: name of house to create.
     * @param address: address of house to create.
     * @param sqFt: square footage of house to create
     * @param price: price of house to create.
     * @param numBed: number of bedrooms in house to create.
     * @param numBath: number of bathrooms in house to create.
     * @param numLaundry: number of laundry rooms in house to create.
     * @param numKitchen: number of kitchens in house to create
     */
    void createHouse(String name, String address, String sqFt, String price, String numBed,
                     String numBath, String numLaundry, String numKitchen, String userID);

    /**
     * Creates a condo object.
     *
     * @param name: name of condo to create.
     * @param address: address of condo to create.
     * @param sqFt: square footage of condo to create
     * @param price: price of condo to create.
     * @param numBed: number of bedrooms in condo to create.
     * @param numBath: number of bathrooms in condo to create.
     * @param numLaundry: number of laundry rooms in condo to create.
     * @param numKitchen: number of kitchens in condo to create
     */
    void createCondo(String name, String address, String sqFt, String price, String numBed,
                     String numBath, String numLaundry, String numKitchen, String userID);

    /**
     * Creates an office object.
     *
     * @param name: name of office to create.
     * @param address: address of office to create.
     * @param sqFt: square footage of office to create
     * @param price: price of office to create.
     * @param numOffice: number of office rooms in office to create.
     * @param numReception: number of receptions in office to create.
     */
    void createOffice(String name, String address, String sqFt, String price, String numOffice,
                      String numReception, String userID);

    /**
     * Creates a restaurant object.
     *
     * @param name: name of restaurant to create.
     * @param address: address of restaurant to create.
     * @param sqFt: square footage of restaurant to create
     * @param price: price of restaurant to create.
     * @param spec: kitchen specifications of restaurant to create.
     */
    void createRestaurant(String name, String address, String sqFt, String price,
                          String spec, String userID);
}
