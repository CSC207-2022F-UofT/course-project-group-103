package interactors;

import entities.Property;
import interactors.containers.PropertyToDisplay;

import java.util.ArrayList;

public class SingleListingInteractor {

    /**
     * Property associated with listing.
     */
    Property p;
    /**
     * Current property being accessed.
     */
    PropertyToDisplay propertyToDisplay;

    /**
     * Constructor for the single-listing interactor, assigns object instances to its attributes.
     *
     * @param p: property instance associated with this single listing interactor.
     * @param pd: PropertyToDisplay class for this application instance's property being accessed.
     */
    public SingleListingInteractor(Property p, PropertyToDisplay pd) {
        this.p = p;
        this.propertyToDisplay = pd;
    }

    /**
     * Returns an Array List of all relevant attributes of the listing.
     * @return Array List of formatted string representations of the listing information.
     */
    public ArrayList<String> listingInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Type: " + p.getType());
        info.add("Address: " + p.getAddress());
        info.add("Price: " + p.getPrice());
        return info;
    }

    /**
     * Sets the currently accessed property to the property associated with this listing.
     */
    public void updateDisplayProperty() {
        this.propertyToDisplay.setPropertyDisplay(p);
    }
}
