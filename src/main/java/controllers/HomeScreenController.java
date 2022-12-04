package controllers;

import interactors.HomeInteractor;

public class HomeScreenController {

    Presenter presenter;
    HomeInteractor homeInteractor;

    public HomeScreenController(Presenter p, HomeInteractor i) {
        this.presenter = p;
        this.homeInteractor = i;
    }

    /**
     * Displays listing page.
     *
     * Calls presenter method to display the listing page which is implemented in the GUI class.
     */
    public void listing() {
        this.presenter.displayListing();
    }

    /**
     * Displays account page
     *
     * Calls presenter method to display the account poge which is implemented in the GUI class.
     */
    public void account() {
        this.presenter.displayActiveAccount();
    }

    /**
     * Displays create listing page
     *
     * Calls presenter method to display the create listing poge which is implemented in the GUI class.
     */
    public void createListing() {
        this.presenter.displayCreateListing();
    }
}
