package presenters;

import interactors.*;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.LoadAccountInput;
import interactors.input_boundary.LoadListingInput;
import interactors.output_boundary.LoadAccountOutput;
import interactors.output_boundary.LoadListingOutput;

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
    public HomeScreenPresenter(ViewInterface p, PropertyGateway g, ReviewGateway rg) {
        this.viewInterface = p;
        this.loadListingInput = new LoadListingInteractor(g, this);
        this.loadAccountInput = new LoadAccountInteractor(g, rg, this);
    }

    /**
     * Calls the use case input method load listing.
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
     * Calls the use case input method load account
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
     * Tells the view to display the create listing page.
     */
    public void onCreateListing() {
        this.viewInterface.displayCreateListing();
    }

    public void onRealtorListing() {
        this.viewInterface.displayRealtorListing();
    }
}
