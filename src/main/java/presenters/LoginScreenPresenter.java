package presenters;
import interactors.LoginInteractor;

public class LoginScreenPresenter {

    LoginInteractor loginInteractor;
    ViewInterface viewInterface;

    public LoginScreenPresenter(LoginInteractor interactor, ViewInterface view) {
        this.loginInteractor = interactor;
        this.viewInterface = view;
    }

    /**
     * Controls user login.
     *
     * Calls the login method of the interactor and if successful displays the home page.
     *
     * @param username: String representing the given username.
     * @param password: String representing the given password.
     */
    public void onLogin(String username, String password) throws Exception {
        this.loginInteractor.login(username, password);
        // if login doesn't throw exception
        this.viewInterface.displayHome();
    }

    /**
     * Displays sign up page.
     *
     * Calls the present method displaySignUp().
     */
    public void onSignUp() {
        this.viewInterface.displaySignUp();
    }
}
