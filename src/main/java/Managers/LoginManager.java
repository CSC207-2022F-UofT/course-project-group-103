package Managers;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
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

    public User getUsers(){

        return null;
    }

    public Realtor getRealtors(){

        return null;
    }

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

    public void changePassword(){

    }

    public void displayAlert(){

    }
}