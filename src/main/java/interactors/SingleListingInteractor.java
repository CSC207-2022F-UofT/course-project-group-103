package interactors;

import entities.Property;
import interactors.containers.PropertyToDisplay;

import java.util.ArrayList;

public class SingleListingInteractor {
    Property p;
    PropertyToDisplay propertyToDisplay;

    public SingleListingInteractor(Property p, PropertyToDisplay pd) {
        this.p = p;
        this.propertyToDisplay = pd;
    }

    public ArrayList<String> listingInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Address: " + p.getAddress());
        info.add("Price: " + p.getPrice());
        return info;
    }

    public void updateDisplayProperty() {
        this.propertyToDisplay.setPropertyDisplay(p);
    }
}
