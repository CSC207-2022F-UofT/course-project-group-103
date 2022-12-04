package interactors;

import entities.*;
import interactors.containers.ActiveUser;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateListingInteractor {

    ActiveUser activeUser;
    PropertyListingGateway propertyListingGateway;
    LoginGateway loginGateway;

    public CreateListingInteractor(ActiveUser u, PropertyListingGateway g, LoginGateway l) {
        this.activeUser = u;
        this.propertyListingGateway = g;
        this.loginGateway = l;
    }

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
        this.propertyListingGateway.save(h);
    }

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
        this.propertyListingGateway.save(c);
    }

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
        this.propertyListingGateway.save(o);
    }

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
        this.propertyListingGateway.save(r);
    }

    public void upgradeToOwner() throws Exception {
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

    private String getValidID() {
        ArrayList<Property> properties = this.propertyListingGateway.getProperties();
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
