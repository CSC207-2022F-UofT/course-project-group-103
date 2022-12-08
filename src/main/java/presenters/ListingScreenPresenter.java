package presenters;

import interactors.AccessPropertyInteractor;
import interactors.PropertyModel;
import interactors.RefreshListingInteractor;
import interactors.SingleListingModel;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.RefreshListingInput;
import interactors.output_boundary.AccessPropertyOutput;
import interactors.output_boundary.LoadListingOutput;
import interactors.output_boundary.RefreshListingOutput;

import java.util.ArrayList;

public class ListingScreenPresenter implements RefreshListingOutput, AccessPropertyOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with refresh listing use case.
     */
    RefreshListingInput refreshListingInput;
    /**
     * Interface for presenter to interact with access property use case.
     */
    AccessPropertyInteractor accessPropertyInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the property gateway interface.
     * @param l: implementation of the review gateway interface
     */
    public ListingScreenPresenter(ViewInterface view, PropertyGateway g, LoginGateway l) {
        this.viewInterface = view;
        this.refreshListingInput = new RefreshListingInteractor(g, this);
        this.accessPropertyInput = new AccessPropertyInteractor(g, l,this);
    }

    /**
     * Tells the view to display previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Calls the refresh listing input method, passing in all parameters.
     *
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

    /**
     * @see RefreshListingOutput
     * Tells the view to refresh the listings passing in the listing model.
     */
    @Override
    public void onUpdateFilterSuccess(ArrayList<SingleListingModel> info) {
        this.viewInterface.refreshListing(info);
    }

    /**
     * @see LoadListingOutput
     * Tells the view to display an failure passing in failure message.
     */
    @Override
    public void onUpdateFilterFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Calls the access property input method passing in the property id.
     *
     * @param PropertyID: id of property to access.
     */
    public void onAccessProperty(String PropertyID) {
        this.accessPropertyInput.accessProperty(PropertyID);
    }

    /**
     * @see AccessPropertyOutput
     * Tells the view to display the property page passing in the property model.
     */
    @Override
    public void onAccessPropertySuccess(PropertyModel property) {
        this.viewInterface.displayProperty(property);
    }

    /**
     * @see LoadListingOutput
     * Tells the view to display a failure passing in failure message.
     */
    @Override
    public void onAccessPropertyFailure(String message) {
        this.viewInterface.displayFailure(message);
    }
}
