package interactors.gateway_interfaces;

import entities.User;

import java.io.IOException;
import java.util.ArrayList;

public interface LoginGateway {
    ArrayList<User> getUsers();
    void saveUser(User u) throws Exception;
    void removeUser(String id);
}
