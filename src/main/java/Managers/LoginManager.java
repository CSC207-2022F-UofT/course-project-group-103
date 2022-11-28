package Managers;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import Interactors.LoginDatabaseGateway;
import org.json.JSONArray;
import org.json.JSONObject;

import Users.*;

public class LoginManager implements LoginDatabaseGateway {

    public void checkDatabase(String user, String password){

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

    public void changePassword(){

    }

    public void displayAlert(){

    }

}
