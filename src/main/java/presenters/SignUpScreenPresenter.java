package presenters;

import interactors.SignUpInteractor;

public class SignUpScreenPresenter {

    SignUpInteractor signUpInteractor;
    ViewInterface viewInterface;

    public SignUpScreenPresenter(SignUpInteractor i, ViewInterface p) {
        this.signUpInteractor = i;
        this.viewInterface = p;
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
     * @throws Exception: failed to sign up
     */
    public void onSignUp(String username, String contact, String password,
                           String confirm_password) throws Exception {
        this.signUpInteractor.signUp(username, contact, password, confirm_password);
        // if sign up doesn't throw exception
        this.viewInterface.displayHome();
    }
}
