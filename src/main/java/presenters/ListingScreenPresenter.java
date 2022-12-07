package presenters;

import interactors.ListingInteractor;
import interactors.SingleListingInteractor;

import java.util.ArrayList;

public class ListingScreenPresenter {

    ListingInteractor listingInteractor;
    ViewInterface viewInterface;

    public ListingScreenPresenter(ListingInteractor i, ViewInterface p) {
        this.listingInteractor = i;
        this.viewInterface = p;
    }

    /**
     * Creates controllers for each single listing panel.
     *
     * Calls the listing interactor to create single listing interactors and
     * loops over them creating a list of single listing controllers.
     */
    public ArrayList<SingleListingPresenter> onCreateListings() {
        ArrayList<SingleListingPresenter> controllers = new ArrayList<>();
        for (SingleListingInteractor i: this.listingInteractor.createListings()) {
            controllers.add(new SingleListingPresenter(i, this.viewInterface));
        }
        return controllers;
    }

    /**
     * Goes back to home page.
     *
     * Calls presenter method to display home page which is implemented in the GUI class.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Sends the inputted filters to the Listing Interactor.
     *
     * Calls the listing interactor method updateFilters() with the inputted filters.
     * @param price: String representation of price given by user
     * @param sqft: String representation of sqft given by user
     * @param house: boolean of whether house should be displayed
     * @param condo: boolean of whether condo should be displayed
     * @param office: boolean of whether office should be displayed
     * @param restaurant: boolean of whether restaurant should be displayed
     */
    public void onListingUpdate(String price, String sqft,
                                  boolean house, boolean condo, boolean office, boolean restaurant) {
        this.listingInteractor.updateFilter(price, sqft, house, condo, office, restaurant);
    }

    /**
     * Sends a filter reset request to the listing interactor.
     *
     * Calls the listing interactor method resetFilter()
     */
    public void onListingReset() {this.listingInteractor.resetFilter();}
}
