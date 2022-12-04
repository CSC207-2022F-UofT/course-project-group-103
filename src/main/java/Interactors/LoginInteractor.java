package Interactors;

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

    LoginDatabaseGateway g;

    public LoginInteractor(LoginDatabaseGateway g){
        this.g = g;
    }

    public void loginUser(String user, String password){

        //Checks if the user is user type "User". Should go in controller after taking input from UI.
//        JSONObject data = this.g.checkDatabase();
//        Set<String> keys = data.keySet();

//        for(String id: keys){
//            JSONObject p = data.getJSONObject(id);
//
//            if(Objects.equals(data.getString("user_type"), "User")){
//                String username = p.getString("name");
//                String pass = p.getString("password");
//                if((Objects.equals(username, user)) && (Objects.equals(pass, password)))
//
//            }
//        }
    }

    public void loginOwner(String user, String password){

    }

    public void loginRealtor(String user, String password){

    }
}
