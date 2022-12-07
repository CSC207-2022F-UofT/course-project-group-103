package screens;

import exceptions.LoginNotFoundException;
import interactors.LoginInteractor;

public class LoginPageController {

    LoginInteractor loginInteractor;

    public LoginPageController(LoginInteractor loginInteractor){

        this.loginInteractor = loginInteractor;
    }

    public void login(String user, String password) throws LoginNotFoundException {

        loginInteractor.loginUser(user, password);
    }
}
