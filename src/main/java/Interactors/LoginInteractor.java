package Interactors;

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

    public void logIntoAccount(String user, String password){

    }
}
