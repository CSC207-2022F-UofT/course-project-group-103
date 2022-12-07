package presenters;

import interactors.*;

import java.util.ArrayList;

public class PropertyScreenPresenter {
    PropertyInteractor propertyInteractor;
    ViewInterface viewInterface;

    public PropertyScreenPresenter(PropertyInteractor interactor, ViewInterface p) {
        this.propertyInteractor = interactor;
        this.viewInterface = p;
    }

    /**
     * Returns a list of information relevant to the property.
     *
     * Calls the PropertyPageInteractor method propertyInfo() and returns the result.
     */
    public ArrayList<String> onInfoList() {
        return this.propertyInteractor.propertyInfo();
    }

    /**
     * Controls the bidding use case.
     *
     * Calls the PropertyPageInteractor method sendBid().
     *
     * @throws Exception: bid fails to send.
     */
    public void onSendBid(String bid) throws Exception {
        this.propertyInteractor.sendBid(bid);
    }

    /**
     * Returns whether the active user is the owner of the property.
     *
     * Calls the PropertyPageInteractor method checkOwner() and returns the result.
     */
    public boolean onCheckOwner() {
        return this.propertyInteractor.checkOwner();
    }

    /**
     * Display the previous page.
     *
     * Calls the presenter method displayPrevious() which is implemented in the GUI class.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Returns a list of SingleBidControllers representing all bids on the property.
     *
     * Calls the PropertyPageInteractor method createBids() and iterates over the resulting
     * list of SingleBidInteractors create a list of SingleBidControllers.
     */
    public ArrayList<SingleBidPresenter> onCreateBids() {
        ArrayList<SingleBidPresenter> controllers = new ArrayList<>();
        for (SingleBidInteractor i: this.propertyInteractor.createBids()) {
            controllers.add(new SingleBidPresenter(i, this.viewInterface));
        }
        return controllers;
    }

    /**
     * Sends a request to delete property to the property interactor.
     *
     * Calls the property interactor method deleteProperty() and then displays home page if successful.
     *
     * @param password: string representation of password for confirmation
     * @throws Exception: failed to delete property
     */
    public void onDeleteProperty(String password) throws Exception {
        this.propertyInteractor.deleteProperty(password);
        this.viewInterface.clearPrevious();
        this.viewInterface.displayHome();
    }

    /**
     * Displays the account page of the properties' owner.
     *
     * Calls the property interactor method updateAccountToDisplay() to change it to the owner account and then
     * calls the presenter method to display the account page.
     */
    public void onOwnerAccount() {
        this.propertyInteractor.updateAccountToDisplay();
        this.viewInterface.displayAccount();
    }
}
