package interactors.gateway_interfaces;

import entities.User;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;
import java.util.ArrayList;

public interface LoginGateway {
    ArrayList<User> getUsers();
    void saveUser(User u) throws Exception;
    void removeUser(String id);
    void savePassword(User user, String newPassword) throws IOException;
    User getUser(String ID) throws IOException, UndefinedUserType;
    String getSecurityQuestion(String ID) throws IOException;
}
