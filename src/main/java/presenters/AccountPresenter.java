package presenters;

import interactors.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.AccessPropertyInput;
import interactors.output_boundary.AccessPropertyOutput;

public class AccountPresenter implements AccessPropertyOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with use case.
     */
    AccessPropertyInput accessPropertyInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the property gateway interface.
     * @param lg: implementation of the login gateway interface.
     */
    public AccountPresenter(ViewInterface view, PropertyGateway g, LoginGateway lg) {
        this.viewInterface = view;
        this.accessPropertyInput = new AccessPropertyInteractor(g, lg, this);
    }

    /**
     * Called when the user input to go to the previous page is given. Tells the view
     * to display the previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Called when the user input to go to a property. Calls the access property input method passing in
     * the id of the property.
     *
     * @param id: property id to go to.
     */
    public void onAccessProperty(String id) {
        this.accessPropertyInput.accessProperty(id);
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
     * @see AccessPropertyOutput
     * Tells the view to display a failure passing in a failure message.
     */
    @Override
    public void onAccessPropertyFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Called when user inputs to create a review. Tells the view to display the
     * create review screen for a given account id.
     *
     * @param id: id of user to review.
     */
    public void onAddReview(String id) {
        this.viewInterface.displayCreateReview(id);
    }
}
