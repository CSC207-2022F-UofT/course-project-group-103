package presenters;

import entities.Review;
import interactors.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.DeletePropertyInput;
import interactors.input_boundary.LoadAccountInput;
import interactors.input_boundary.SendBidInput;
import interactors.output_boundary.DeletePropertyOutput;
import interactors.output_boundary.LoadAccountOutput;
import interactors.output_boundary.SendBidOutput;

import java.util.ArrayList;

public class PropertyScreenPresenter implements SendBidOutput, LoadAccountOutput, DeletePropertyOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with send bid use case.
     */
    SendBidInput sendBidInput;
    /**
     * Interface for presenter to interact with load account use case.
     */
    LoadAccountInput loadAccountInput;
    /**
     * Interface for presenter to interact with delete property use case.
     */
    DeletePropertyInput deletePropertyInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the property gateway interface.
     * @param gr: implementation of the review gateway interface
     */
    public PropertyScreenPresenter(ViewInterface view, PropertyGateway g, LoginGateway l, ReviewGateway gr) {
        this.viewInterface = view;
        this.sendBidInput = new SendBidInteractor(g, this);
        this.loadAccountInput = new LoadAccountInteractor(g, l, gr, this);
        this.deletePropertyInput = new DeletePropertyInteractor(g, this);
    }

    /**
     * Tells the view to display previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Calls the use case input method load account passing in the id of account to load.
     *
     * @param bidderID: id of bidder account to load.
     */
    public void onBidderAccount(String bidderID) {
        this.loadAccountInput.loadAccount(bidderID);
    }

    /**
     * Calls the use case input method load account passing in the id of account to load.
     *
     * @param ownerID: id of owner account to load.
     */
    public void onOwnerAccount(String ownerID) {
        this.loadAccountInput.loadAccount(ownerID);
    }

    /**
     * @see LoadAccountOutput
     * Tells the view to display the account screen passing in the account info models.
     */
    @Override
    public void onLoadAccountSuccess(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                                     AccountModel account) {
        this.viewInterface.displayAccount(listings, reviews, account);
    }

    /**
     * @see LoadAccountOutput
     * Tells the view to display a failure passing in the failure message.
     */
    @Override
    public void onLoadAccountFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Calls the use case input method send bid passing in the parameters.
     *
     * @param propertyID: id of property to assign bid to.
     * @param bid: bid to send.
     */
    public void onSendBid(String propertyID, String bid) {
        this.sendBidInput.sendBid(propertyID, bid, this.viewInterface.getActiveUser());
    }

    /**
     * @see SendBidOutput
     * Tells the view to display a success.
     */
    @Override
    public void onSendBidSuccess() {
        this.viewInterface.displaySuccess("Bid Sent.");
    }

    /**
     * @see SendBidOutput
     * Tells the view to display a failure passing in the failure message.
     */
    @Override
    public void onSendBidFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Calls the use case input method delete property passing in the parameters.
     *
     * @param id: id of property.
     * @param password: password of owner.
     */
    public void onDelete(String id, String password) {
        this.deletePropertyInput.deleteProperty(id, password);
    }

    /**
     * @see DeletePropertyOutput
     * Tells the view to display home and display a success.
     */
    @Override
    public void onDeletePropertySuccess() {
        this.viewInterface.displayHome();
        this.viewInterface.displaySuccess("Property Deleted.");
    }

    /**
     * @see DeletePropertyOutput
     * Tells the view to display a failure passing in the failure message.
     */
    @Override
    public void onDeletePropertyFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onEstimateMortgage(float price) {this.viewInterface.displayMortgageEstimator(price);}

}
