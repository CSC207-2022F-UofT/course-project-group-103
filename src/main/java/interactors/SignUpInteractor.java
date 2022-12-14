package interactors;

import entities.User;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.SignUpInput;
import interactors.output_boundary.SignUpOutput;
import java.util.ArrayList;

public class SignUpInteractor implements SignUpInput {

    /**
     * Gateway interface to property JSON with read/write methods.
     */
    LoginGateway loginGateway;
    /**
     * Output interface for sign up interactor.
     */
    SignUpOutput singnUpOutput;

    /**
     * Constructor for the sign-up interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of the loginGateway interface.
     * @param ob: implementation of the output interface for sign up
     */
    public SignUpInteractor(LoginGateway g, SignUpOutput ob) {
        this.loginGateway = g;
        this.singnUpOutput = ob;
    }

    /**
     * @see SignUpInput
     * Checks if the username already exists and if the passwords match and then creates a new user saving
     * it to the database, then calls the output interface passing in the user ID.
     */
    public void signUp(String username, String contact, String password, String confirm_password) {
        if (!password.equals(confirm_password)) {
            this.singnUpOutput.onSignUpFailure("Passwords do not match.");
            return;
        }
        if (this.usernameExists(username)) {
            this.singnUpOutput.onSignUpFailure("Username already exists.");
            return;
        }
        User u = new User(this.getValidID(), username, password, contact);
        try {
            this.loginGateway.saveUser(u);
        }
        catch (Exception e) {
            this.singnUpOutput.onSignUpFailure("Failed to save.");
            return;
        }
        this.singnUpOutput.onSignUpSuccess(u.getID());
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
