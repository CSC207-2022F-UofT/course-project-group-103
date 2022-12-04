package controllers;

import interactors.*;

import java.util.ArrayList;

public class PropertyScreenController {
    PropertyInteractor propertyInteractor;
    Presenter presenter;

    public PropertyScreenController(PropertyInteractor interactor, Presenter p) {
        this.propertyInteractor = interactor;
        this.presenter = p;
    }

    /**
     * Returns a list of information relevant to the property.
     *
     * Calls the PropertyPageInteractor method propertyInfo() and returns the result.
     */
    public ArrayList<String> getInfoList() {
        return this.propertyInteractor.propertyInfo();
    }

    /**
     * Controls the bidding use case.
     *
     * Calls the PropertyPageInteractor method sendBid().
     *
     * @throws Exception: bid fails to send.
     */
    public void sendBid(String bid) throws Exception {
        this.propertyInteractor.sendBid(bid);
    }

    /**
     * Returns whether the active user is the owner of the property.
     *
     * Calls the PropertyPageInteractor method checkOwner() and returns the result.
     */
    public boolean checkOwner() {
        return this.propertyInteractor.checkOwner();
    }

    /**
     * Display the listing page.
     *
     * Calls the presenter method displayListings() which is implemented in the GUI class.
     */
    public void back() {
        this.presenter.displayPrevious();
    }

    /**
     * Returns a list of SingleBidControllers representing all bids on the property.
     *
     * Calls the PropertyPageInteractor method createBids() and iterates over the resulting
     * list of SingleBidInteractors create a list of SingleBidControllers.
     */
    public ArrayList<SingleBidController> createBids() {
        ArrayList<SingleBidController> controllers = new ArrayList<>();
        for (SingleBidInteractor i: this.propertyInteractor.createBids()) {
            controllers.add(new SingleBidController(i, this.presenter));
        }
        return controllers;
    }
}
