package interactors;

import entities.users.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserGateway {
    /**
     * Removes the User with the specified user and password/user ID from the User
     * database. Removes their properties and bids from all databases and unassigns their ID.
     */
    public void removeUser(String name, String password, String ID) throws IOException {
        String jsonStringUser = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject users = new JSONObject(jsonStringUser);
        JSONObject userInfo = (JSONObject) users.get(String.valueOf(ID));

        if (userInfo.getString("name").equals(name) &&
                userInfo.getString("password").equals(password)) {

            users.remove(ID);
            String jsonStringProperty = Files.readString(Paths.get("src\\main\\Databases\\PropertyListing.json"));
            JSONObject properties = new JSONObject(jsonStringProperty);
            JSONArray keys = properties.names();

            for (int i = 0; i < keys.length(); i++) {
                String key = keys.getString(i);
                JSONObject propertyInfo = (JSONObject) properties.get(key);
                if (!propertyInfo.isNull("owner") &&
                        propertyInfo.getString("owner").equals(ID)) {
                    properties.remove(key);
                }
            }

            try (FileWriter file = new FileWriter("src\\main\\Databases\\UserListing.json")) {
                file.write(users.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try (FileWriter file = new FileWriter("src\\main\\Databases\\PropertyListing.json")) {
                file.write(properties.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Returns a list of all realtors.
     *
     * @return ArrayList of all realtors
     */
    public ArrayList<Realtor> getRealtors() throws IOException {
        ArrayList<Realtor> realtors = new ArrayList<>();

        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject users = new JSONObject(jsonString);
        JSONArray keys = users.names();

        for (int i = 0; i < keys.length(); i++) {
            String key = keys.getString(i);
            JSONObject user = users.getJSONObject(key);

            if (user.getString("user_type").equals("Realtor")) {
                String name = user.getString("name");
                String password = user.getString("password");
                String contact = user.getString("contact");
                String securityQuestion = user.getString("securityQuestion");
                String securityAnswer = user.getString("securityAnswer");
                realtors.add(new Realtor(key, name, password, contact, securityQuestion, securityAnswer));
            }
        }

        return realtors;
    }
}
