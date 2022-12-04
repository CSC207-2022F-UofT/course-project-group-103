package controllers;

import interactors.SingleListingInteractor;
import java.util.ArrayList;

public class SingleListingController {
    SingleListingInteractor singleListingInteractor;
    Presenter presenter;

    public SingleListingController(SingleListingInteractor i, Presenter p) {
        this.singleListingInteractor = i;
        this.presenter = p;
    }

    /**
     * Returns a list of basic info on a property.
     *
     * Calls the SingleListingInteractor method listingInfo().
     */
    public ArrayList<String> getListingInfo() {
        return this.singleListingInteractor.listingInfo();
    }

    /**
     * Displays property page.
     *
     * Calls the presenter method to display property implemented in GUI.
     */
    public void showProperty() {
        this.singleListingInteractor.updateDisplayProperty();
        this.presenter.displayProperty();
    }
}
