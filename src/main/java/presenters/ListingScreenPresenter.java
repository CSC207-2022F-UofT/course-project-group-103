package presenters;

import interactors.AccessPropertyInteractor;
import interactors.PropertyModel;
import interactors.RefreshListingInteractor;
import interactors.SingleListingModel;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.RefreshListingInput;
import interactors.output_boundary.AccessPropertyOutput;
import interactors.output_boundary.RefreshListingOutput;

import java.util.ArrayList;

public class ListingScreenPresenter implements RefreshListingOutput, AccessPropertyOutput {

    ViewInterface viewInterface;
    RefreshListingInput refreshListingInput;
    AccessPropertyInteractor accessPropertyInput;

    public ListingScreenPresenter(ViewInterface view, PropertyGateway g, LoginGateway l) {
        this.viewInterface = view;
        this.refreshListingInput = new RefreshListingInteractor(g, this);
        this.accessPropertyInput = new AccessPropertyInteractor(g, l,this);
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
    public void onListingUpdate(String price, String sqft, boolean house, boolean condo,
                                boolean office, boolean restaurant) {
        this.refreshListingInput.updateFilter(price, sqft, house, condo, office, restaurant);
    }

    public void onUpdateFilterSuccess(ArrayList<SingleListingModel> info) {
        this.viewInterface.refreshListing(info);
    }

    public void onUpdateFilterFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onAccessProperty(String PropertyID) {
        this.accessPropertyInput.accessProperty(PropertyID);
    }

    public void onAccessPropertySuccess(PropertyModel property) {
        this.viewInterface.displayProperty(property);
    }

    public void onAccessPropertyFailure(String message) {
        this.viewInterface.displayFailure(message);
    }
}
