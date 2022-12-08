package presenters;

import interactors.*;
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

    ViewInterface viewInterface;
    SendBidInput sendBidInput;
    LoadAccountInput loadAccountInput;
    DeletePropertyInput deletePropertyInput;

    public PropertyScreenPresenter(ViewInterface view, PropertyGateway g, ReviewGateway gr) {
        this.viewInterface = view;
        this.sendBidInput = new SendBidInteractor(g, this);
        this.loadAccountInput = new LoadAccountInteractor(g, gr, this);
        this.deletePropertyInput = new DeletePropertyInteractor(g, this);
    }
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    public void onBidderAccount(String bidderID) {
        this.loadAccountInput.loadAccount(bidderID);
    }

    public void onOwnerAccount(String ownerID) {
        this.loadAccountInput.loadAccount(ownerID);
    }

    public void onLoadAccountSuccess(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                                     AccountModel account) {
        this.viewInterface.displayAccount(listings, reviews, account);
    }

    public void onLoadAccountFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onSendBid(String propertyID, String bid) {
        this.sendBidInput.sendBid(propertyID, bid, this.viewInterface.getActiveUser());
    }

    public void onSendBidSuccess() {
        this.viewInterface.displaySuccess("Bid Sent.");
    }

    public void onSendBidFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onDelete(String id, String password) {
        this.deletePropertyInput.deleteProperty(id, password);
    }

    public void onDeletePropertySuccess() {
        this.viewInterface.displayHome();
        this.viewInterface.displaySuccess("Property Deleted.");
    }

    public void onDeletePropertyFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onEstimateMortgage(float price) {this.viewInterface.displayMortgageEstimator(price);}

}
