package Managers;

import Interactors.LoginDatabaseGateway;
import Review.Review;
import org.json.*;

import java.nio.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;

import Users.*;


public class LoginManager implements LoginDatabaseGateway {

    public JSONObject checkDatabase(){
        try{
            Path filePath = Path.of("src/main/Databases/PropertyListing.json");
            String content = Files.readString(filePath);
            return new JSONObject(content);

        }catch(IOException e){
            throw new RuntimeException();
        }

    }

    /**
     * Adds a new user to the user database if sign up requirements are met.
     *
     * Creates a new User object and assigns account information to it, then assigns the
     * object to a unique User ID.
     *
     * @param name: Username the User signed up with
     * @param password: Password the User signed up with
     * @param contact: Contact email the User signed up with
     * @param securityQuestion: Security question the User signed up with
     * @param securityAnswer: Security answer the User signed up with
     */
    public void addUser(String name, String password, String contact, String securityQuestion, String securityAnswer) throws IOException {

    }

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
     * Returns the realtor with the associated ID.
     *
     * @param ID: ID of the user to return
     * @return The user with the associated ID
     */
    public Realtor getRealtor(String ID) throws IOException {
        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject obj = new JSONObject(jsonString);
        JSONObject info = (JSONObject) obj.get(ID);

        if (info.getString("user_type").equals("Realtor")) {
            String name = info.getString("name");
            String password = info.getString("password");
            String contact = info.getString("contact");
            String securityQuestion = info.getString("securityQuestion");
            String securityAnswer = info.getString("securityAnswer");

            return new Realtor(ID, name, password, contact,
                    securityQuestion, securityAnswer);
        }
        return null;
    }

    public void changePassword(User user, String newPassword){

        if(verifyPassword(newPassword)){
            user.setPassword(newPassword);
            displayAlert(); //alert saying "password was changed"
        }else
            displayAlert(); //alert saying "invalid password"
    }

    public boolean verifyPassword(String password) {
        int passLength = 8;
        char[] passArray = password.toCharArray();
        boolean length = false;
        boolean caps = false;
        boolean number = false;

        if(password.length() >= passLength)
            length = true;

        for (char c : passArray) {
            if (Character.isUpperCase(c)) {
                caps = true;
                break;
            }

        }

        for (char c : passArray) {
            if (Character.isDigit(c)) {
                number = true;
                break;
            }
        }

        return length && caps && number;

    }
    
    /**
    * Displays and alert on the sign-up or login page.
    * Displays an alert for invalid passwords, successfully made accounts, passwords not matching during sign-up
    * password verification, etc.
    */
    public void displayAlert () {

    }
}
