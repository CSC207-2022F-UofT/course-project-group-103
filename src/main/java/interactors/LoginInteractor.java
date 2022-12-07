package interactors;

import entities.User;
import interactors.containers.ActiveUser;
import interactors.gateway_interfaces.LoginGateway;

import java.util.ArrayList;

public class LoginInteractor {
    /**
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;
    /**
     * Current active user of the application.
     */
    ActiveUser activeUser;

    /**
     * Constructor for the login interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of loginGateway interface.
     * @param a: ActiveUser class for this application instance's current active user.
     */
    public LoginInteractor(LoginGateway g, ActiveUser a) {
        this.loginGateway = g;
        this.activeUser = a;
    }

    /**
     * Searches database to find whether password and username exist in it, if they do
     * log the user in under the associated account.
     *
     * @param username: given username.
     * @param password: given password.
     * @throws Exception: failed to log in.
     */
    public void login(String username, String password) throws Exception {
        ArrayList<User> users = loginGateway.getUsers();
        for (User u: users) {
            String user = u.getName();
            String pass = u.getPassword();
            if (user.equals(username) && pass.equals(password)) {
                this.activeUser.setActiveUser(u);
                return;
            }
        }
        throw new Exception("Account doesn't exist.");
    }

// commented out sean's part for merge conflict
/*
import exceptions.LoginNotFoundException;
import presenters.LoginPresenter;
import org.json.JSONObject;

import java.util.Objects;
import java.util.Set;

public class LoginInteractor{

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
     
     /*

    LoginDatabaseGateway g;
    LoginPresenterOB p;

    public LoginInteractor(LoginDatabaseGateway g, LoginPresenterOB p){
        this.g = g;
        this.p = p;
    }

    public void loginUser(String user, String password) throws LoginNotFoundException {

        JSONObject data = this.g.checkDatabase();
        Set<String> keys = data.keySet();

        for(String id: keys){
            JSONObject p = data.getJSONObject(id);

            if(Objects.equals(data.getString("user_type"), "User")){
                String username = p.getString("name");
                String pass = p.getString("password");
                if((Objects.equals(username, user)) && (Objects.equals(pass, password))){
                    this.p.present("User");
                }else
                    throw new LoginNotFoundException("Incorrect login information, please try again.");

            }else if(Objects.equals(data.getString("user_type"), "Owner")){
                String username = p.getString("name");
                String pass = p.getString("password");
                if((Objects.equals(username, user)) && (Objects.equals(pass, password))){
                    this.p.present("Owner");
                }else
                    throw new LoginNotFoundException("Incorrect login information, please try again.");

            }else if(Objects.equals(data.getString("user_type"), "Realtor")){
                String username = p.getString("name");
                String pass = p.getString("password");
                if((Objects.equals(username, user)) && (Objects.equals(pass, password))){
                    this.p.present("Realtor");
                }else
                    throw new LoginNotFoundException("Incorrect login information, please try again.");
            }
        }
    }

*/
}
