package Managers;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import Users.*;

public class LoginManager {
    public void saveToRealtorListing(Realtor realtor) {
        JSONObject realtorObject = new JSONObject();
        JSONObject realtorObject2 = new JSONObject();
        realtorObject2.put(String.valueOf("name"), realtor.getName());
        realtorObject2.put(String.valueOf("contact"), realtor.getContact());

        realtorObject.put(realtor.getID(), realtorObject2);

        try (FileWriter file = new FileWriter("src\\main\\Databases\\RealtorListing.json")) {
            file.write(realtorObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
