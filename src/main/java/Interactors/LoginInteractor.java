package interactors;

import entities.User;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.LoginInput;
import interactors.output_boundary.LoginOuput;

import java.util.ArrayList;

public class LoginInteractor implements LoginInput {
    /**
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;
    /**
     * Output interface for login interactor.
     */
    LoginOuput loginOuput;

    /**
     * Constructor for the login interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of loginGateway interface.
     * @param ob: implementation of output boundary interface.
     */
    public LoginInteractor(LoginGateway g, LoginOuput ob) {
        this.loginGateway = g;
        this.loginOuput = ob;
    }

    /**
     * Searches database to find whether password and username exist in it, if they do
     * log the user in under the associated account.
     *
     * @param username: given username.
     * @param password: given password.
     */
    public void login(String username, String password) {
        ArrayList<User> users = loginGateway.getUsers();
        for (User u: users) {
            String user = u.getName();
            String pass = u.getPassword();
            if (user.equals(username) && pass.equals(password)) {
                this.loginOuput.onLoginSuccess(u.getID());
                return;
            }
        }
        this.loginOuput.onLoginFailure("Account Does Not Exist");
    }
}
