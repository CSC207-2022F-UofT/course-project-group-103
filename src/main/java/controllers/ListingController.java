package controllers;

import interactors.ListingInteractor;
import interactors.SingleListingInteractor;

import java.util.ArrayList;

public class ListingController {

    ListingInteractor listingInteractor;
    Presenter presenter;

    public ListingController(ListingInteractor i, Presenter p) {
        this.listingInteractor = i;
        this.presenter = p;
    }

    /**
     * Creates controllers for each single listing panel.
     *
     * Calls the listing interactor to create single listing interactors and
     * loops over them creating a list of single listing controllers.
     */
    public ArrayList<SingleListingController> createListings() {
        ArrayList<SingleListingController> controllers = new ArrayList<>();
        for (SingleListingInteractor i: this.listingInteractor.createListings()) {
            controllers.add(new SingleListingController(i, this.presenter));
        }
        return controllers;
    }

    /**
     * Goes back to home page.
     *
     * Calls presenter method to display home page which is implemented in the GUI class.
     */
    public void back() {
        this.presenter.displayPrevious();
    }

    public void sendListingUpdate(String price, String sqft) {
        this.listingInteractor.updateFilter(price, sqft);
    }
    public void sendListingTypeUpdate(boolean house, boolean condo, boolean office, boolean restaurant) {
        this.listingInteractor.updateTypeFilter(house, condo,office,restaurant);
    }
    public void sendListingReset() {this.listingInteractor.resetFilter();}
}
