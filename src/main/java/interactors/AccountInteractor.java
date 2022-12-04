package interactors;

import entities.Property;
import entities.User;
import interactors.containers.*;

import java.util.ArrayList;

public class AccountInteractor {

    AccountToDisplay accountToDisplay;
    ActiveUser activeUser;
    PropertyToDisplay propertyToDisplay;
    PropertyListingGateway propertyListingGateway;

    public AccountInteractor(AccountToDisplay a, ActiveUser u, PropertyToDisplay p, PropertyListingGateway g) {
        this.accountToDisplay = a;
        this.activeUser = u;
        this.propertyToDisplay = p;
        this.propertyListingGateway = g;
    }

    public ArrayList<SingleListingInteractor> createUserProperties() {
        ArrayList<Property> properties = this.propertyListingGateway.getProperties();
        ArrayList<SingleListingInteractor> interactors = new ArrayList<>();
        for (Property p: properties) {
            if (p.getOwner().getID().equals(this.accountToDisplay.getAccountDisplay().getID())) {
                interactors.add(new SingleListingInteractor(p, propertyToDisplay));
            }
        }
        return interactors;
    }

    public ArrayList<String> getInfo() {
        if (this.accountToDisplay.getAccountDisplay()!=null) {
            ArrayList<String> info = new ArrayList<>();
            info.add("Name: " + this.accountToDisplay.getAccountDisplay().getName());
            info.add("Contact: " + this.accountToDisplay.getAccountDisplay().getContact());
            return info;
        }
        ArrayList<String> empty = new ArrayList<>();
        empty.add("error");
        return empty;
    }

    public boolean isOwnerType() {
        if (this.accountToDisplay.getAccountDisplay()!=null) {
            return this.accountToDisplay.getAccountDisplay().getClass().getName().replace(
                    "entities.", "").equals("Owner");
        }
        return false;
    }
}
