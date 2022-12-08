package presenters;

import interactors.SignUpInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.SignUpInput;
import interactors.output_boundary.SignUpOutput;

public class SignUpScreenPresenter implements SignUpOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with sign up use case.
     */
    SignUpInput signUpInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param p: implementation of the view interface.
     * @param g: implementation of the login gateway interface.
     */
    public SignUpScreenPresenter(ViewInterface p, LoginGateway g) {
        this.viewInterface = p;
        this.signUpInput = new SignUpInteractor(g, this);
    }

    /**
     * Tells the view to display previous page.
     */
    public void onBack() {
        this.viewInterface.displayLogin();
    }

    /**
     * Calls theinput method sign up passing in parameters.
     *
     * @param username: String representation of the username
     * @param contact: String representation of the contact info
     * @param password: String representation of password
     * @param confirm_password: String representation of the user password confirmation
     */
    public void onSignUp(String username, String contact, String password,
                         String confirm_password) {
        this.signUpInput.signUp(username, contact, password, confirm_password);
    }

    /**
     * @see SignUpOutput
     * Tells the driver to update the active user passing in the id and then tells view to display home.
     */
    @Override
    public void onSignUpSuccess(String id) {
        this.viewInterface.setActiveUser(id);
        this.viewInterface.displayHome();
    }

    /**
     * @see SignUpOutput
     * Tells the view to display a failure passing in the failure message.
     */
    @Override
    public void onSignUpFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

}
