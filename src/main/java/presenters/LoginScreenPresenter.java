package presenters;
import interactors.LoginInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.LoginInput;
import interactors.output_boundary.LoginOuput;

public class LoginScreenPresenter implements LoginOuput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with login use case.
     */
    LoginInput loginInteractor;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the login gateway interface.
     */
    public LoginScreenPresenter(ViewInterface view, LoginGateway g) {
        this.viewInterface = view;
        this.loginInteractor = new LoginInteractor(g,this);
    }

    /**
     * Calls the login input method passing in the parameters.
     *
     * @param username: String representing the given username.
     * @param password: String representing the given password.
     */
    public void onLogin(String username, String password) {
        this.loginInteractor.login(username, password);
    }

    /**
     * @see LoginOuput
     * Tells the driver to update the active user and tells the view to display home.
     */
    @Override
    public void onLoginSuccess(String id) {
        this.viewInterface.setActiveUser(id);
        this.viewInterface.displayHome();
    }

    /**
     * @see LoginOuput
     * Tells view to display a failure passing in a failure message.
     */
    @Override
    public void onLoginFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Tells the view to display sign up page.
     */
    public void onSignUp() {
        this.viewInterface.displaySignUp();
    }
}
