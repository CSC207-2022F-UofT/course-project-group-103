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
     * @see LoginInput
     * Accesses all user objects stored in the user database and searches through them to see if
     * any username password combination matches and then calls the output interface passing in
     * the users ID.
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

    /**
     * Searches database to find the security question corresponding to the inputted user.
     *
     * @param username: given username.
     * @return securityQuestion: corresponding security question.
     */

    public String getSecurityQuestion(String username) {
        ArrayList<User> users = loginGateway.getUsers();
        for (User u: users) {
            if (u.getName().equals(username)) {
                return u.getSecurityQuestion();
            }
        }
        return null;

    }
}
