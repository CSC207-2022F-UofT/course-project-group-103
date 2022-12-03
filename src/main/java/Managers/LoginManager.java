package Managers;

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

public class LoginManager {
    /**
     * Logs in a normal user with no title that is not a property owner/buyer or a realtor.
     *
     * Goes through the database and checks if the user and password entered by the User
     * is logged as a regular user (not as an Owner or Realtor). If true, then the User is logged
     * in and is given access to information pertaining to their account.
     *
     * @param user: Username entered by the User
     * @param password: Password entered by the User
     */
    public void login(String user, String password){

    }

    /**
     * Logs in an Owner user that is not a realtor.
     *
     * Goes through the database and checks if the user and password entered by the User is
     * logged as an Owner user (not as a Realtor). If true, then the User is logged in and is
     * given access to information pertaining to their account and permissions relating to an Owner.
     *
     * @param user: Username entered by the User
     * @param password: Password entered by the User
     */
    public void loginOwner(String user, String password){

    }

    /**
     * Logs in an Owner user that is not a realtor.
     *
     * Goes through the database and checks if the user and password entered by the User is
     * logged as an Owner user (not as a Realtor). If true, then the User is logged in and is
     * given access to information pertaining to their account and permissions relating to an Owner.
     *
     * @param user: Username entered by the User
     * @param password: Password entered by the User
     */
    public void loginRealtor(String user, String password){

    }

    public void checkDatabase(){

    }

    /**
     * Adds a new user to the user database if sign up requirements are met.
     *
     * Creates a new User object and assigns account information to it, then assigns the
     * object to a unique User ID.
     *
     * @param user: Username the User signed up with
     * @param password: Password the User signed up with
     */
    public void addUser(String user, String password){

    }

    /**
     * Removes the User with the specified user and password/user ID from the User
     * database. Removes their properties and bids from all databases and unassigns their ID.
     */
    public void removeUser(){

    }

    /**
     * Returns the user given with the associated ID.
     *
     * @param ID: ID of the user to return
     * @return The user with the associated ID
     */
    public User getUser(int ID) throws IOException {
        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject obj = new JSONObject(jsonString);
        JSONObject info = (JSONObject) obj.get(String.valueOf(ID));

        if (info.getString("user_type").equals("User")) {
            String name = info.getString("name");
            String password = info.getString("password");
            String contact = info.getString("contact");
            String securityQuestion = info.getString("securityQuestion");
            String securityAnswer = info.getString("securityAnswer");

            if (info.get("hiredRealtor") instanceof String) {
                String hiredRealtorID = info.getString("hiredRealtor");
                return new User(String.valueOf(ID), name, password, contact,
                        hiredRealtorID, securityQuestion, securityAnswer);
            } else {
                return new User(String.valueOf(ID), name, password, contact,
                        securityQuestion, securityAnswer);
            }
        }
        return null;
    }

    /**
     * Returns the realtor given with the associated ID.
     *
     * @param ID: ID of the user to return
     * @return The user with the associated ID
     */
    public Realtor getRealtor(int ID) throws IOException {
        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject obj = new JSONObject(jsonString);
        JSONObject info = (JSONObject) obj.get(String.valueOf(ID));

        if (info.getString("user_type").equals("Realtor")) {
            String name = info.getString("name");
            String password = info.getString("password");
            String contact = info.getString("contact");
            String securityQuestion = info.getString("securityQuestion");
            String securityAnswer = info.getString("securityAnswer");

            return new Realtor(String.valueOf(ID), name, password, contact,
                    securityQuestion, securityAnswer);
        }
        return null;
    }

    public void saveToRealtorListing(Realtor realtor) throws IOException {
        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\RealtorListing.json"));

        JSONObject realtorObj = new JSONObject(jsonString);
        JSONObject realtorInfoObj = new JSONObject();
        realtorInfoObj.put("name", realtor.getName());
        realtorInfoObj.put("contact", realtor.getContact());
        realtorObj.put(realtor.getID(), realtorInfoObj);

        try (FileWriter file = new FileWriter("src\\main\\Databases\\RealtorListing.json")) {
            file.write(realtorObj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePassword(){

    }

    public void displayAlert(){

    }
}