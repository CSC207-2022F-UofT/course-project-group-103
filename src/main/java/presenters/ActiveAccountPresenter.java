package presenters;

import interactors.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.AccessPropertyInput;
import interactors.input_boundary.ChangePasswordInput;
import interactors.input_boundary.DeleteAccountInput;
import interactors.output_boundary.AccessPropertyOutput;
import interactors.output_boundary.DeleteAccountOutput;

import java.io.IOException;

public class ActiveAccountPresenter implements AccessPropertyOutput, DeleteAccountOutput{

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with the use case of accessing a property.
     */
    AccessPropertyInput accessPropertyInput;
    /**
     * Interface for presenter to interact with use case of deleting account.
     */
    DeleteAccountInput deleteAccountInput;
    ChangePasswordInput changePasswordInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the property gateway interface.
     * @param lg: implementation of the login gateway interface.
     * @param rg: implementation of the review gateway interface.
     */
    public ActiveAccountPresenter(ViewInterface view, PropertyGateway g, LoginGateway lg, ReviewGateway rg) {
        this.viewInterface = view;
        this.accessPropertyInput = new AccessPropertyInteractor(g, lg, this);
        this.deleteAccountInput = new DeleteAccountInteractor(g, lg, rg, this);
    }

    /**
     * Called when the user input to go to the previous page is given. Tells the view
     * to display the previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Called when the user input to go to a property. Tells the view to
     * display the page of the given id.
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
     * Called when the user input to go to sign out. Tells the driver to remove the active user and tells the view to
     * display the login page.
     */
    public void onSignOut() {
        this.viewInterface.setActiveUser(null);
        this.viewInterface.displayLogin();
    }

    /**
     * Called when the user input to delete their account. Calls delete account input method passing in
     * the password.
     *
     * @param password: password given by user.
     */
    public void onDeleteAccount(String password) {
        this.deleteAccountInput.deleteAccount(this.viewInterface.getActiveUser(), password);
    }

    /**
     * @see DeleteAccountOutput
     * Called when the user input to go to sign out. Tells the driver to remove the active user and tells the view to
     * display the login page.
     */
    @Override
    public void onDeleteAccountSuccess() {
        this.viewInterface.setActiveUser(null);
        this.viewInterface.displayLogin();
    }

    /**
     * @see DeleteAccountOutput
     * Tells the view to display a failure passing in the failure message.
     */
    @Override
    public void onDeleteAccountFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onOpenChangePassword(String securityQuestion) throws IOException {
        this.viewInterface.displayChangePassword(securityQuestion);
    }

}
