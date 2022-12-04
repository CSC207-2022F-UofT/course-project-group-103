package interactors;

import entities.User;
import interactors.containers.ActiveUser;

import java.util.ArrayList;

public class LoginInteractor {
    LoginGateway loginGateway;
    ActiveUser activeUser;

    public LoginInteractor(LoginGateway g, ActiveUser a) {
        this.loginGateway = g;
        this.activeUser = a;
    }

    public boolean login(String username, String password) {
        ArrayList<User> users = loginGateway.getUsers();
        for (User u: users) {
            String user = u.getName();
            String pass = u.getPassword();
            if (user.equals(username) && pass.equals(password)) {
                this.activeUser.setActiveUser(u);
                return true;
            }
        }
        return false;
    }
}
