package controllers;
import entities.User;
import interactors.LoginInteractor;

public class LoginScreenController {

    LoginInteractor loginInteractor;
    Presenter presenter;

    public LoginScreenController(LoginInteractor i, Presenter p) {
        this.loginInteractor = i;
        this.presenter = p;
    }

    /**
     * Controls user login.
     *
     * Calls the login method of the interactor and if successful displays the home page.
     *
     * @param username: String representing the given username.
     * @param password: String representing the given password.
     */
    public boolean login(String username, String password) {
        if (loginInteractor.login(username, password)) {
            this.presenter.displayHome();
            return true;
        }
        return false;
    }

    public void signUp() {
        this.presenter.displaySignUp();
    }
}
