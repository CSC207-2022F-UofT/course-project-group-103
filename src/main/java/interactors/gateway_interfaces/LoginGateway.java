package interactors.gateway_interfaces;

import entities.User;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;
import java.util.ArrayList;

public interface LoginGateway {
    /**
     * Gets a list of users in the database.
     * @return Array list of user objects.
     */
    ArrayList<User> getUsers();
    /**
     * Saves a user to the database.
     *
     * @param u: user to save to the database.
     */
    void saveUser(User u) throws Exception;
    /**
     * Removes the user associated with the id from the database.
     *
     * @param id: id of user to remove.
     */
    void removeUser(String id);
    void savePassword(User user, String newPassword) throws IOException;
    User getUser(String ID) throws IOException, UndefinedUserType;
    String getSecurityQuestion(String ID) throws IOException;
}
