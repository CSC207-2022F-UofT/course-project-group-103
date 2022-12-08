package presenters;
import interactors.LoginInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.LoginInput;
import interactors.output_boundary.LoginOuput;

import java.io.IOException;

public class LoginScreenPresenter implements LoginOuput {

    ViewInterface viewInterface;
    LoginInput loginInteractor;

    public LoginScreenPresenter(ViewInterface view, LoginGateway g) {
        this.viewInterface = view;
        this.loginInteractor = new LoginInteractor(g,this);
    }

    /**
     * Controls user login.
     *
     * Calls the login method of the interactor and if successful displays the home page.
     *
     * @param username: String representing the given username.
     * @param password: String representing the given password.
     */
    public void onLogin(String username, String password) {
        this.loginInteractor.login(username, password);
    }

    /**
     * Displays home screen.
     */
    public void onLoginSuccess(String id) {
        this.viewInterface.setActiveUser(id);
        this.viewInterface.displayHome();
    }

    /**
     * Displays a failure message.
     */
    public void onLoginFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Displays sign up page.
     */
    public void onSignUp() {
        this.viewInterface.displaySignUp();
    }

    public void onOpenChangePassword(String name, String failure_message) throws IOException {
        if (this.loginInteractor.getSecurityQuestion(name) == null) {
            onChangePasswordFailure(failure_message);
        } else {
            this.viewInterface.displayChangePasswordInactive(this.loginInteractor.getSecurityQuestion(name));
        }
    }

    public void onChangePasswordFailure(String message) {
        this.viewInterface.displayFailure(message);
    }
}
