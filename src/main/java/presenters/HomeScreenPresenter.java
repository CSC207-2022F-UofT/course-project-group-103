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

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with load listing use case.
     */
    LoadListingInput loadListingInput;
    /**
     * Interface for presenter to interact with load account use case.
     */
    LoadAccountInput loadAccountInput;
    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param p: implementation of the view interface.
     * @param g: implementation of the property gateway interface.
     * @param rg: implementation of the review gateway interface
     */
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

    /**
     * @see LoadListingOutput
     * Tells the view to refresh the listings passing in the listing model and then display the listing screen.
     */
    @Override
    public void onLoadListingSuccess(ArrayList<SingleListingModel> info) {
        this.viewInterface.refreshListing(info);
        this.viewInterface.displayListing();
    }

    /**
     * @see LoadListingOutput
     * Tells the view to display a failure message passing in the failure message.
     */
    @Override
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



    /**
     * @see LoadAccountOutput
     * Tells the view to display the account page passing in the info models.
     */
    @Override
    public void onLoadAccountSuccess(ArrayList<SingleListingModel> listings,
                                     ArrayList<ReviewModel> reviews, AccountModel account) {
        this.viewInterface.displayActiveAccount(listings, reviews, account);
    }

    /**
     * @see LoadListingOutput
     * Tells the view to display a failure message passing in the failure message.
     */
    @Override
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

    public void onRealtorListing() {
        this.viewInterface.displayRealtorListing();
    }
}
