package Interactors;

import Users.Realtor;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import Managers.LoginManager;

public class RealtorSearchInteractor {
    public ArrayList<Realtor> listRealtors() throws IOException {
        LoginManager loginManager = new LoginManager();
        ArrayList<Realtor> realtors = new ArrayList<>();

        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject users = new JSONObject(jsonString);
        JSONArray keys = users.names();

        for (int i = 0; i < keys.length(); i++) {
            String key = keys.getString(i);
            Realtor realtor = loginManager.getRealtor(key);
            if (realtor != null) {
                realtors.add(realtor);
            }
        }
        return realtors;
    }
}
