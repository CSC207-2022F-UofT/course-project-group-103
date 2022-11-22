package Managers;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

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
     * Removes the User with the specified user ID from the User
     * database. Removes their properties and bids from all databases and unassigns their ID.
     *
     * @param userID: User ID of the user deleting their account
     */
    public void removeUser(String userID){

    }

    public User getUsers(){

        return null;
    }

    public Realtor getRealtors(){

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

