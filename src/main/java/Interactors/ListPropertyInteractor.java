package Interactors;

import Properties.*;
import Users.Owner;

import java.io.IOException;

public class ListPropertyInteractor {

    /**
     * Adds a property with type House to the database given specifications
     * @param owner: owner of the property
     * @param name: String indicating the name of the property as an identifier
     * @param address: property address
     * @param sqFt: property size
     * @param price: property price
     * @param bed: number of bedrooms present
     * @param bath: number of bathrooms present
     * @param laundry: number of laundry rooms present
     * @param kitchen: number of kitchens present
     * @return boolean indicating if the listing was successfully made, false if a property with the same name
     *         already exists
     * @throws IOException if the property failed to save
     */
    public static boolean listHouse (Owner owner, String name, String address, int sqFt, float price,
                                     int bed, int bath, int laundry, int kitchen) throws IOException {
        if (PropertyListingGateway.nameExists(name)) return false;
        int database_size = PropertyListingGateway.getNumProperties();

        House p = new House(name, address, Integer.toString(database_size), owner, sqFt, price,
                bed, bath, laundry, kitchen);
        PropertyListingGateway.addProperty(p);
        return true;
    }

    /**
     * Adds a property with type Condo to the database given specifications
     * @param owner: owner of the property
     * @param name: String indicating the name of the property as an identifier
     * @param address: property address
     * @param sqFt: property size
     * @param price: property price
     * @param bed: number of bedrooms present
     * @param bath: number of bathrooms present
     * @param laundry: number of laundry rooms present
     * @param kitchen: number of kitchens present
     * @return boolean indicating if the listing was successfully made, false if a property with the same name
     *         already exists
     * @throws IOException if the property failed to save
     */
    public static boolean listCondo (Owner owner, String name, String address, int sqFt, float price,
                                     int bed, int bath, int laundry, int kitchen) throws IOException {
        if (PropertyListingGateway.nameExists(name)) return false;
        int database_size = PropertyListingGateway.getNumProperties();

        Condo p = new Condo(name, address, Integer.toString(database_size), owner, sqFt, price,
                bed, bath, laundry, kitchen);
        PropertyListingGateway.addProperty(p);
        return true;
    }

    /**
     * Adds a property with type House to the database given specifications
     * @param owner: owner of the property
     * @param name: String indicating the name of the property as an identifier
     * @param address: property address
     * @param sqFt: property size
     * @param price: property price
     * @param kitchenSpecifications: String containing relevant information about the property
     * @return boolean indicating if the listing was successfully made, false if a property with the same name
     *         already exists
     * @throws IOException if the property failed to save
     */
    public static boolean listRestaurant (Owner owner, String name, String address, int sqFt, float price,
                                          String kitchenSpecifications) throws IOException {
        if (PropertyListingGateway.nameExists(name)) return false;
        int database_size = PropertyListingGateway.getNumProperties();

        Restaurant p = new Restaurant(name, address, Integer.toString(database_size), owner, sqFt, price,
                kitchenSpecifications);
        PropertyListingGateway.addProperty(p);
        return true;
    }


    /**
     * Adds a property with type House to the database given specifications
     * @param owner: owner of the property
     * @param name: String indicating the name of the property as an identifier
     * @param address: property address
     * @param sqFt: property size
     * @param price: property price
     * @param office: number of office rooms present in the property
     * @param reception: number of receptions in the property
     * @return boolean indicating if the listing was successfully made, false if a property with the same name
     *         already exists
     * @throws IOException if the property failed to save
     */
    public static boolean listOffice (Owner owner, String name, String address, int sqFt, float price,
                                      int office, int reception) throws IOException {
        if (PropertyListingGateway.nameExists(name)) return false;
        int database_size = PropertyListingGateway.getNumProperties();

        Office p = new Office(name, address, Integer.toString(database_size), owner, sqFt, price,
                office, reception);
        PropertyListingGateway.addProperty(p);
        return true;
    }

}
