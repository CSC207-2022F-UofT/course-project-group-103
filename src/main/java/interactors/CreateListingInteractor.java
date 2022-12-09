package interactors;

import entities.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.CreateListingInput;
import interactors.output_boundary.CreateListingOutput;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateListingInteractor implements CreateListingInput {

    /**
     * Gateway interface to property JSON with read/write methods.
     */
    PropertyGateway propertyGateway;
    /**
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;
    /**
     * Output boundary for create listing interactor.
     */
    CreateListingOutput createListingOutput;

    /**
     * Constructor for the create-listing interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of propertyGateway interface.
     * @param l: implementation of the loginGateway interface.
     * @param ob: implementation of output interface for this interactor.
     */
    public CreateListingInteractor(PropertyGateway g, LoginGateway l, CreateListingOutput ob) {
        this.propertyGateway = g;
        this.loginGateway = l;
        this.createListingOutput = ob;
    }

    /**
     * @see CreateListingInput
     * Creates a house object and saves it to the database.
     */
    @Override
    public void createHouse(String name, String address, String sqFt, String price, String numBed,
                            String numBath, String numLaundry, String numKitchen, String userID) {
        int sqFt_int;
        float price_float;
        int numBed_int;
        int numBath_int;
        int numLaundry_int;
        int numKitchen_int;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for SqFt."); return;}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter a decimal amount for price."); return;}
        try {
            numBed_int = Integer.parseInt(numBed);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of bedrooms."); return;}
        try {
            numBath_int = Integer.parseInt(numBath);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of bathrooms."); return;}
        try {
            numLaundry_int = Integer.parseInt(numLaundry);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of laundry rooms."); return;}
        try {
            numKitchen_int = Integer.parseInt(numKitchen);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of kitchens."); return;}
        try {
            System.out.println("test");
            this.upgradeToOwner(userID);
            House h = new House(name, address, this.getValidID(), (Owner) propertyGateway.getUser(userID),
                    sqFt_int, price_float, numBed_int, numBath_int, numLaundry_int, numKitchen_int, new HashMap<>());
            this.propertyGateway.save(h);
            this.createListingOutput.onCreateListingSuccess();
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure("Save failed.");}
    }

    /**
     * @see CreateListingInput
     * Creates a condo object and saves it to the database.
     */
    @Override
    public void createCondo(String name, String address, String sqFt, String price, String numBed,
                            String numBath, String numLaundry, String numKitchen, String userID) {
        int sqFt_int;
        float price_float;
        int numBed_int;
        int numBath_int;
        int numLaundry_int;
        int numKitchen_int;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for SqFt."); return;}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter a decimal amount for price."); return;}
        try {
            numBed_int = Integer.parseInt(numBed);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of bedrooms."); return;}
        try {
            numBath_int = Integer.parseInt(numBath);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of bathrooms."); return;}
        try {
            numLaundry_int = Integer.parseInt(numLaundry);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of laundry rooms."); return;}
        try {
            numKitchen_int = Integer.parseInt(numKitchen);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of kitchens."); return;}
        try {
            this.upgradeToOwner(userID);
            Condo c = new Condo(name, address, this.getValidID(), (Owner) propertyGateway.getUser(userID),
                    sqFt_int, price_float, numBed_int, numBath_int, numLaundry_int, numKitchen_int, new HashMap<>());
            this.propertyGateway.save(c);
            this.createListingOutput.onCreateListingSuccess();
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure("Save failed.");}
    }

    /**
     * @see CreateListingInput
     * Creates an office object and saves it to the database.
     */
    @Override
    public void createOffice(String name, String address, String sqFt, String price, String numOffice,
                             String numReception, String userID) {
        int sqFt_int;
        float price_float;
        int numOffice_int;
        int numReception_int;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for SqFt."); return;}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter a decimal amount for price."); return;}
        try {
            numOffice_int = Integer.parseInt(numOffice);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of office rooms."); return;}
        try {
            numReception_int = Integer.parseInt(numReception);
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for number of receptions."); return;}
        try {
            this.upgradeToOwner(userID);
            Office o = new Office(name, address, this.getValidID(), (Owner) propertyGateway.getUser(userID),
                    sqFt_int, price_float, numOffice_int, numReception_int, new HashMap<>());
            this.propertyGateway.save(o);
            this.createListingOutput.onCreateListingSuccess();
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure("Save failed.");}
    }

    /**
     * @see CreateListingInput
     * Creates a restaurant object and saves it to the database.
     */
    @Override
    public void createRestaurant(String name, String address, String sqFt, String price,
                                 String spec, String userID) {
        int sqFt_int;
        float price_float;

        try {
            sqFt_int = Integer.parseInt(sqFt);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter an integer amount for SqFt."); return;}
        try {
            price_float = Float.parseFloat(price);
        } catch(Exception e) {this.createListingOutput.onCreateListingFailure(
                "Enter a decimal amount for price."); return;}
        try {
            this.upgradeToOwner(userID);
            Restaurant r = new Restaurant(name, address, this.getValidID(), (Owner) propertyGateway.getUser(userID),
                    sqFt_int, price_float, spec, new HashMap<>());
            this.propertyGateway.save(r);
            this.createListingOutput.onCreateListingSuccess();
        } catch (Exception e) {this.createListingOutput.onCreateListingFailure(
                "Save failed.");}
    }

    /**
     * Upgrades the active user from a user to an owner if they aren't an owner already.
     *
     * @throws Exception: failed to upgrade user.
     */
    private void upgradeToOwner(String userID) throws Exception {
        User u = propertyGateway.getUser(userID);
        if (!u.getClass().getName().replace(
                "entities.", "").equals("Owner")) {
            Owner o = new Owner(
                    u.getID(),
                    u.getName(),
                    u.getPassword(),
                    u.getContact(),
                    new ArrayList<>()
            );
            this.loginGateway.saveUser(o);
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
