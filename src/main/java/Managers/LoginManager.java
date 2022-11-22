package Managers;

import org.json.JSONObject;
import java.io.FileWriter;
import Users.*;

public class LoginManager {
    public void saveToRealtorListing(Realtor realtor) {
        JSONObject realtorObject = new JSONObject();
        realtorObject.put(String.valueOf(realtor.getID()), realtor.getName());

        try (FileWriter file = new FileWriter("src\\main\\Databases\\RealtorListing.json")) {
            file.write(realtorObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
