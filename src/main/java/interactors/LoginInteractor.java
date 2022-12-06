package interactors;

import entities.User;
import interactors.containers.ActiveUser;
import interactors.gateway_interfaces.LoginGateway;

import java.util.ArrayList;

public class LoginInteractor {
    /**
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;
    /**
     * Current active user of the application.
     */
    ActiveUser activeUser;

    /**
     * Constructor for the login interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of loginGateway interface.
     * @param a: ActiveUser class for this application instance's current active user.
     */
    public LoginInteractor(LoginGateway g, ActiveUser a) {
        this.loginGateway = g;
        this.activeUser = a;
    }

    /**
     * Searches database to find whether password and username exist in it, if they do
     * log the user in under the associated account.
     *
     * @param username: given username.
     * @param password: given password.
     * @throws Exception: failed to log in.
     */
    public void login(String username, String password) throws Exception {
        ArrayList<User> users = loginGateway.getUsers();
        for (User u: users) {
            String user = u.getName();
            String pass = u.getPassword();
            if (user.equals(username) && pass.equals(password)) {
                this.activeUser.setActiveUser(u);
                return;
            }
        }
        throw new Exception("Account doesn't exist.");
    }
}
