package interactors;

import entities.*;
import interactors.containers.ActiveUser;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateListingInteractor {

    /**
     * Current user of the application.
     */
    ActiveUser activeUser;
    /**
     * Gateway interface to property JSON with read/write methods.
     */
    PropertyGateway propertyGateway;
    /**
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;

    /**
     * Constructor for the create-listing interactor, assigns object instances to its attributes.
     *
     * @param u: ActiveUser class for this application instance's current active user.
     * @param g: implementation of propertyGateway interface.
     * @param l: implementation of the loginGateway interface.
     */
    public CreateListingInteractor(ActiveUser u, PropertyGateway g, LoginGateway l) {
        this.activeUser = u;
        this.propertyGateway = g;
        this.loginGateway = l;
    }

    /**
     * Creates a house object listed by the user and saves it to the database.
     *
     * @param name: name of the house to create
     * @param address: address of the house to create
     * @param sqFt: square footage of house to create
     * @param price: price of house to create
     * @param numBed: number of bedrooms in house to create
     * @param numBath: number of bathrooms in house to create
     * @param numLaundry: number of laundry rooms in house to create
     * @param numKitchen: number of kitchens in house to create
     *
     * @throws Exception: failed to create the house.
     */
    public void createHouse(String name, String address, String sqFt, String price, String numBed,
                            String numBath, String numLaundry, String numKitchen) throws Exception {
        int sqFt_int;
        float price_float;
        int numBed_int;
        int numBath_int;
        int numLaundry_int;
        int numKitchen_int;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {throw new Exception("Enter an integer amount for SqFt.");}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {throw new Exception("Enter a decimal amount for price.");}
        try {
            numBed_int = Integer.parseInt(numBed);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of bedrooms.");}
        try {
            numBath_int = Integer.parseInt(numBath);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of bathrooms.");}
        try {
            numLaundry_int = Integer.parseInt(numLaundry);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of laundry rooms.");}
        try {
            numKitchen_int = Integer.parseInt(numKitchen);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of kitchens.");}
        try {
            this.upgradeToOwner();
        } catch (Exception e) {throw new Exception("Save failed.");}
        House h = new House(name, address, this.getValidID(), (Owner) this.activeUser.getActiveUser(),
                sqFt_int, price_float, numBed_int, numBath_int, numLaundry_int, numKitchen_int, new HashMap<>());
        this.propertyGateway.save(h);
    }

    /**
     * Creates a condo object listed by the user and saves it to the database.
     *
     * @param name: name of the condo to create
     * @param address: address of the condo to create
     * @param sqFt: square footage of condo to create
     * @param price: price of condo to create
     * @param numBed: number of bedrooms in condo to create
     * @param numBath: number of bathrooms in condo to create
     * @param numLaundry: number of laundry rooms in condo to create
     * @param numKitchen: number of kitchens in condo to create
     *
     * @throws Exception: failed to create the condo.
     */
    public void createCondo(String name, String address, String sqFt, String price, String numBed,
                            String numBath, String numLaundry, String numKitchen) throws Exception {
        int sqFt_int;
        float price_float;
        int numBed_int;
        int numBath_int;
        int numLaundry_int;
        int numKitchen_int;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {throw new Exception("Enter an integer amount for SqFt.");}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {throw new Exception("Enter a decimal amount for price.");}
        try {
            numBed_int = Integer.parseInt(numBed);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of bedrooms.");}
        try {
            numBath_int = Integer.parseInt(numBath);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of bathrooms.");}
        try {
            numLaundry_int = Integer.parseInt(numLaundry);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of laundry rooms.");}
        try {
            numKitchen_int = Integer.parseInt(numKitchen);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of kitchens.");}
        try {
            this.upgradeToOwner();
        } catch (Exception e) {throw new Exception("Save failed.");}
        Condo c = new Condo(name, address, this.getValidID(), (Owner) this.activeUser.getActiveUser(),
                sqFt_int, price_float, numBed_int, numBath_int, numLaundry_int, numKitchen_int, new HashMap<>());
        this.propertyGateway.save(c);
    }

    /**
     * Creates an office object listed by the user and saves it to the database.
     *
     * @param name: name of the office to create
     * @param address: address of the office to create
     * @param sqFt: square footage of office to create
     * @param price: price of office to create
     * @param numOffice: number of office rooms in office to create
     * @param numReception: number of receptions in office to create
     *
     * @throws Exception: failed to create the office.
     */
    public void createOffice(String name, String address, String sqFt, String price, String numOffice,
                            String numReception) throws Exception {
        int sqFt_int;
        float price_float;
        int numOffice_int;
        int numReception_int;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {throw new Exception("Enter an integer amount for SqFt.");}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {throw new Exception("Enter a decimal amount for price.");}
        try {
            numOffice_int = Integer.parseInt(numOffice);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of bedrooms.");}
        try {
            numReception_int = Integer.parseInt(numReception);
        } catch (Exception e) {throw new Exception("Enter an integer amount for number of bathrooms.");}
        try {
            this.upgradeToOwner();
        } catch (Exception e) {throw new Exception("Save failed.");}
        Office o = new Office(name, address, this.getValidID(), (Owner) this.activeUser.getActiveUser(),
                sqFt_int, price_float, numOffice_int, numReception_int, new HashMap<>());
        this.propertyGateway.save(o);
    }

    /**
     * Creates a restaurant object listed by the user and saves it to the database.
     *
     * @param name: name of the restaurant to create
     * @param address: address of the restaurant to create
     * @param sqFt: square footage of restaurant to create
     * @param price: price of restaurant to create
     * @param spec: kitchen specifications of restaurant to create
     *
     * @throws Exception: failed to create the restaurant.
     */
    public void createRestaurant(String name, String address, String sqFt, String price,
                                 String spec) throws Exception {
        int sqFt_int;
        float price_float;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {throw new Exception("Enter an integer amount for SqFt.");}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {throw new Exception("Enter a decimal amount for price.");}
        try {
            this.upgradeToOwner();
        } catch (Exception e) {throw new Exception("Save failed.");}
        Restaurant r = new Restaurant(name, address, this.getValidID(), (Owner) this.activeUser.getActiveUser(),
                sqFt_int, price_float, spec, new HashMap<>());
        this.propertyGateway.save(r);
    }

    /**
     * Upgrades the active user from a user to an owner if they aren't an owner already.
     *
     * @throws Exception: failed to upgrade user.
     */
    private void upgradeToOwner() throws Exception {
        if (!this.activeUser.getActiveUser().getClass().getName().replace(
                "entities.", "").equals("Owner")) {
            Owner o = new Owner(
                    this.activeUser.getActiveUser().getID(),
                    this.activeUser.getActiveUser().getName(),
                    this.activeUser.getActiveUser().getPassword(),
                    this.activeUser.getActiveUser().getContact(),
                    new ArrayList<>()
            );
            this.loginGateway.saveUser(o);
            this.activeUser.setActiveUser(o);
        }
    }

    /**
     * Searches the properties in the property database to find the lowest unused ID.
     * @return string of the lowest unused ID.
     */
    private String getValidID() {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        for (int i = 0; i < properties.size(); i++) {
            for (int j = 0; j < properties.size(); j++) {
                if (properties.get(j).getID().equals(Integer.toString(i))) {
                    break;
                } else if (j == properties.size()-1) {
                    return Integer.toString(i);
                }
            }
        }
        return Integer.toString(properties.size());
    }
}
