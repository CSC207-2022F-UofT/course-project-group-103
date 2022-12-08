package interactors;

import entities.Realtor;
import entities.User;
import managers.LoginManager;

import java.util.ArrayList;

public class RealtorSearchInteractor {
    /**
     * Returns a list of list of realtors, where each inner list has a single realtor's name and contact information.
     * @return List of list of realtors
     */
    public ArrayList<ArrayList<String>> listRealtors(){
        LoginManager lm = new LoginManager("src/main/databases/UserListing.json", "src/main/databases/ReviewList.json");
        ArrayList<User> userArrayList = lm.getUsers();
        ArrayList<ArrayList<String>> realtors = new ArrayList<>();

        for (User u: userArrayList) {
            if (u instanceof Realtor) {
                ArrayList<String> realtorInfo = new ArrayList<>();
                realtorInfo.add(u.getName());
                realtorInfo.add(u.getContact());
                realtors.add(realtorInfo);
            }
        }
        return realtors;
    }
}
