package interactors;
import entities.Realtor;
import entities.User;
import managers.LoginManager;

import java.io.IOException;
import java.util.ArrayList;

public class RealtorClientsInteractor {
    /**
     * Gets the clients of a realtor, given a realtor's ID.
     * @param ID The realtor's ID
     * @return List of all clients
     */
    public ArrayList<User> getClients(String ID) {
        LoginManager lm = new LoginManager("src/main/databases/UserListing.json", "src/main/databases/ReviewList.json");
        ArrayList<User> userArrayList = lm.getUsers();
        ArrayList<User> clients = new ArrayList<>();
        for (User u: userArrayList) {
            if (u.getHiredRealtorID().equals(ID)) {
                clients.add(u);
            }
        }
        return clients;
    }

    /**
     * Gets the realtor hired by a user, given a user's ID.
     * @param ID The user's ID
     * @return Realtor ID
     */
    public String getRealtor(String ID) {
        LoginManager lm = new LoginManager("src/main/databases/UserListing.json", "src/main/databases/ReviewList.json");
        ArrayList<User> userArrayList = lm.getUsers();
        for (User u: userArrayList) {
            if (u.getID().equals(ID)) {
                return u.getHiredRealtorID();
            }
        }
        return null;
    }

    public void hireRealtor(String uID, String rID) {
        LoginManager lm = new LoginManager("src/main/databases/UserListing.json", "src/main/databases/ReviewList.json");
        ArrayList<User> userArrayList = lm.getUsers();
        for (User u: userArrayList) {
            if (u.getID().equals(uID)) {
                u.hireRealtor(rID);
                try {
                    lm.saveUser(u);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
