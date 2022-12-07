package presenters;

import interactors.SignUpInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.SignUpInput;
import interactors.output_boundary.SignUpOutput;

public class SignUpScreenPresenter implements SignUpOutput {

    ViewInterface viewInterface;
    SignUpInput signUpInput;

    public SignUpScreenPresenter(ViewInterface p, LoginGateway g) {
        this.viewInterface = p;
        this.signUpInput = new SignUpInteractor(g, this);
    }

    /**
     * Display the previous page.
     *
     * Calls the presenter method displayPrevious() which is implemented in the GUI class.
     */
    public void onBack() {
        this.viewInterface.displayLogin();
    }

    /**
     * Send sign up request to the sign-up interactor.
     *
     * Calls the interactor method signUp()
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

    public void onSignUpSuccess(String id) {
        this.viewInterface.setActiveUser(id);
        this.viewInterface.displayHome();
    }

    public void onSignUpFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

}
