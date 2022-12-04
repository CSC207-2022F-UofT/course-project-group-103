package interactors;

import entities.Property;
import interactors.containers.ListingFilters;
import interactors.containers.PropertyToDisplay;

import java.util.ArrayList;
import java.util.List;

public class ListingInteractor {
    PropertyListingGateway propertyListingGateway;
    PropertyToDisplay propertyToDisplay;
    ListingFilters filters;

    public ListingInteractor(PropertyListingGateway g, PropertyToDisplay p, ListingFilters f) {
        this.propertyListingGateway = g;
        this.propertyToDisplay = p;
        this.filters = f;
    }

    public ArrayList<SingleListingInteractor> createListings() {
        ArrayList<Property> properties = propertyListingGateway.getProperties();
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

    public void updateFilter(String price_range, String sqft_range) {
        String[] pricerange = price_range.split("-");
        String[] sqftrange = sqft_range.split("-");
        this.filters.setPriceRange(Float.parseFloat(pricerange[0]), Float.parseFloat(pricerange[1]));
        this.filters.setSqFtRange(Float.parseFloat(sqftrange[0]), Float.parseFloat(sqftrange[1]));
    }

    public void updateTypeFilter(Boolean house, Boolean condo, Boolean office, Boolean restaurant) {
        this.filters.setShowHouse(house);
        this.filters.setShowCondo(condo);
        this.filters.setShowOffice(office);
        this.filters.setShowRestaurant(restaurant);
    }

    public void resetFilter() {
        this.filters.setPriceRange(0, 0);
        this.filters.setSqFtRange(0,0);
        this.filters.setShowHouse(false);
        this.filters.setShowCondo(false);
        this.filters.setShowOffice(false);
        this.filters.setShowRestaurant(false);
    }
}
