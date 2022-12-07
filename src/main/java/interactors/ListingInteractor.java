package interactors;

import entities.Property;
import interactors.containers.ListingFilters;
import interactors.containers.PropertyToDisplay;
import interactors.gateway_interfaces.PropertyGateway;

import java.util.ArrayList;

public class ListingInteractor {

    /**
     * Gateway interface to property JSON with read/write methods.
     */
    PropertyGateway propertyGateway;
    /**
     * Current property being accessed.
     */
    PropertyToDisplay propertyToDisplay;
    /**
     * Current listing filters.
     */
    ListingFilters filters;

    /**
     * Constructor for the listing interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of propertyGateway interface.
     * @param p: PropertyToDisplay class for this application instance's current accessed property.
     * @param f: ListingFilters class for this application instance's of current filters.
     */
    public ListingInteractor(PropertyGateway g, PropertyToDisplay p, ListingFilters f) {
        this.propertyGateway = g;
        this.propertyToDisplay = p;
        this.filters = f;
    }

    /**
     * Creates an array list of single listing interactors for properties that meet the current filters to
     * be passed to the presenter.
     * @return array list of SingleListingInteractors
     */
    public ArrayList<SingleListingInteractor> createListings() {
        ArrayList<Property> properties = propertyGateway.getProperties();
        ArrayList<SingleListingInteractor> interactors = new ArrayList<>();
        for (Property p: properties) {
            if (this.filters.getMaxPrice()==0 || this.filters.getMaxSqFt()==0 ||
                    !(this.filters.getShowHouse() || this.filters.getShowCondo() || this.filters.getShowOffice() ||
                            this.filters.getShowRestaurant())) {
                interactors.add(new SingleListingInteractor(p, this.propertyToDisplay));
            }
            else if (p.getPrice() >= this.filters.getMinPrice() && p.getPrice() <= this.filters.getMaxPrice()) {
                if (p.getSqFt() >= this.filters.getMinSqFt() && p.getSqFt() <= this.filters.getMaxSqFt()) {
                    if ((p.getType().equals("House") && this.filters.getShowHouse()) ||
                            (p.getType().equals("Condo") && this.filters.getShowCondo()) ||
                            (p.getType().equals("Office") && this.filters.getShowOffice()) ||
                            (p.getType().equals("Restaurant") && this.filters.getShowRestaurant())) {
                        interactors.add(new SingleListingInteractor(p, this.propertyToDisplay));
                    }
                }
            }
        }
        return interactors;
    }

    /**
     * Updates the current filters to the inputted filter.
     *
     * @param price_range: Formatted string of a price range, example "1-100"
     * @param sqft_range: Formatted string of a square footage range, example "1-100"
     * @param house: Whether house should be displayed.
     * @param condo: Whether condo should be displayed.
     * @param office: Whether office should be displayed.
     * @param restaurant: Whether restaurant should be displayed.
     */
    public void updateFilter(String price_range, String sqft_range,
                             boolean  house, boolean condo, boolean office, boolean restaurant) {
        String[] pricerange = price_range.split("-");
        String[] sqftrange = sqft_range.split("-");
        this.filters.setPriceRange(Float.parseFloat(pricerange[0]), Float.parseFloat(pricerange[1]));
        this.filters.setSqFtRange(Integer.parseInt(sqftrange[0]), Integer.parseInt(sqftrange[1]));
        this.filters.setShowHouse(house);
        this.filters.setShowCondo(condo);
        this.filters.setShowOffice(office);
        this.filters.setShowRestaurant(restaurant);
    }

    /**
     * Resets the current filters.
     */
    public void resetFilter() {
        this.filters.setPriceRange(0, 0);
        this.filters.setSqFtRange(0,0);
        this.filters.setShowHouse(false);
        this.filters.setShowCondo(false);
        this.filters.setShowOffice(false);
        this.filters.setShowRestaurant(false);
    }
}
