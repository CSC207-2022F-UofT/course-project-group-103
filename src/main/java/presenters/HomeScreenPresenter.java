package presenters;

import interactors.*;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.LoadAccountInput;
import interactors.input_boundary.LoadListingInput;
import interactors.output_boundary.LoadAccountOutput;
import interactors.output_boundary.LoadListingOutput;

import java.io.IOException;
import java.util.ArrayList;

public class HomeScreenPresenter implements LoadListingOutput, LoadAccountOutput {

    ViewInterface viewInterface;
    LoadListingInput loadListingInput;
    LoadAccountInput loadAccountInput;

    public HomeScreenPresenter(ViewInterface p, PropertyGateway g, LoginGateway l, ReviewGateway rg) {
        this.viewInterface = p;
        this.loadListingInput = new LoadListingInteractor(g, this);
        this.loadAccountInput = new LoadAccountInteractor(g, l, rg, this);
    }

    /**
     * Displays listing page.
     *
     * Calls presenter method to display the listing page which is implemented in the GUI class.
     */
    public void onLoadListing() {
        this.loadListingInput.loadListing();
    }

    public void onLoadListingSuccess(ArrayList<SingleListingModel> info) {
        this.viewInterface.refreshListing(info);
        this.viewInterface.displayListing();
    }

    public void onLoadListingFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Displays account page
     *
     * Calls presenter method to display the account page which is implemented in the GUI class.
     */
    public void onLoadAccount() {
        this.loadAccountInput.loadAccount(this.viewInterface.getActiveUser());
    }

    public void onLoadAccountSuccess(ArrayList<SingleListingModel> listings,
                                     ArrayList<ReviewModel> reviews, AccountModel account) {
        this.viewInterface.displayActiveAccount(listings, reviews, account);
    }

    public void onLoadAccountFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Displays create listing page
     *
     * Calls presenter method to display the create-listing page which is implemented in the GUI class.
     */
    public void onCreateListing() {
        this.viewInterface.displayCreateListing();
    }

    public void onOpenMessenger() throws MessengerNotFound, UndefinedUserType, IOException
    {this.viewInterface.displayChat(null);}
}
