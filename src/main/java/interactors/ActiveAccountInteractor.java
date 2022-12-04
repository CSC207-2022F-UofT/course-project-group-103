package interactors;

import entities.Property;
import interactors.containers.*;

import java.util.ArrayList;

public class ActiveAccountInteractor {

    ActiveUser activeUser;
    PropertyToDisplay propertyToDisplay;
    PropertyListingGateway propertyListingGateway;

    public ActiveAccountInteractor(ActiveUser u, PropertyToDisplay p, PropertyListingGateway g) {
        this.activeUser = u;
        this.propertyToDisplay = p;
        this.propertyListingGateway = g;
    }

    public ArrayList<SingleListingInteractor> createUserProperties() {
        ArrayList<Property> properties = this.propertyListingGateway.getProperties();
        ArrayList<SingleListingInteractor> interactors = new ArrayList<>();
        for (Property p: properties) {
            if (p.getOwner().getID().equals(this.activeUser.getActiveUser().getID())) {
                interactors.add(new SingleListingInteractor(p, propertyToDisplay));
            }
        }
        return interactors;
    }

    public ArrayList<String> getInfo() {
        if (this.activeUser.getActiveUser()!=null) {
            ArrayList<String> info = new ArrayList<>();
            info.add("Name: " + this.activeUser.getActiveUser().getName());
            info.add("Contact: " + this.activeUser.getActiveUser().getContact());
            return info;
        }
        ArrayList<String> empty = new ArrayList<>();
        empty.add("error");
        return empty;
    }

    public boolean isOwnerType() {
        if (this.activeUser.getActiveUser()!=null) {
            return this.activeUser.getActiveUser().getClass().getName().replace(
                    "entities.", "").equals("Owner");
        }
        return false;
    }

    public void signOut() {
        this.activeUser.setActiveUser(null);
    }
}
