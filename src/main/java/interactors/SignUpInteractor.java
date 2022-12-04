package interactors;

import entities.Property;
import entities.User;
import interactors.containers.ActiveUser;

import java.util.ArrayList;

public class SignUpInteractor {

    ActiveUser activeUser;
    LoginGateway loginGateway;

    public SignUpInteractor(ActiveUser u, LoginGateway g) {
        this.activeUser = u;
        this.loginGateway = g;
    }

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

    public boolean usernameExists(String username) {
        ArrayList<User> users = this.loginGateway.getUsers();
        for (User u: users) {
            if (u.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public String getValidID() {
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
