package interactors;

import entities.User;
import interactors.containers.ActiveUser;
import interactors.gateway_interfaces.LoginGateway;

import java.util.ArrayList;

public class SignUpInteractor {

    /**
     * Current active user of the application.
     */
    ActiveUser activeUser;
    /**
     * Gateway interface to property JSON with read/write methods.
     */
    LoginGateway loginGateway;

    /**
     * Constructor for the sign-up interactor, assigns object instances to its attributes.
     *
     * @param u: ActiveUser class for this application instance's current active user.
     * @param g: implementation of the loginGateway interface.
     */
    public SignUpInteractor(ActiveUser u, LoginGateway g) {
        this.activeUser = u;
        this.loginGateway = g;
    }

    /**
     * Creates a new user class and save it to the database, then update the active user to the new account.
     *
     * @param username: username of account to create.
     * @param contact: contact information of account to create.
     * @param password: password of account to create.
     * @param confirm_password: repetition of password of account to create.
     */
    public void signUp(String username, String contact, String password, String confirm_password) throws Exception {
        if (!password.equals(confirm_password)) {
            throw new Exception("Passwords do not match.");
        }
        if (this.usernameExists(username)) {
            throw new Exception("Username already in use.");
        }
        User u = new User(this.getValidID(), username, password, contact);
        this.loginGateway.saveUser(u);
        this.activeUser.setActiveUser(u);
    }

    /**
     * Check if a username already is in use by an account in the database.
     * @return if a username is in the database (true) or not (false).
     */
    private boolean usernameExists(String username) {
        ArrayList<User> users = this.loginGateway.getUsers();
        for (User u: users) {
            if (u.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches the users in the user database to find the lowest unused ID.
     * @return string of the lowest unused ID.
     */
    private String getValidID() {
        ArrayList<User> users = this.loginGateway.getUsers();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).getID().equals(Integer.toString(i))) {
                    break;
                } else if (j == users.size()-1) {
                    return Integer.toString(i);
                }
            }
        }
        return Integer.toString(users.size());
    }
}
