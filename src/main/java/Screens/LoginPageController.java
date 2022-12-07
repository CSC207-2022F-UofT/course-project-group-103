package Screens;

import Exceptions.InvalidPasswordException;
import Exceptions.LoginNotFoundException;
import Interactors.LoginInteractor;
import Interactors.SignupInteractor;

import java.io.IOException;

public class LoginPageController {

    LoginInteractor loginInteractor;
    SignupInteractor signupInteractor;

    public LoginPageController(LoginInteractor loginInteractor, SignupInteractor signupInteractor){

        this.loginInteractor = loginInteractor;
        this.signupInteractor = signupInteractor;
    }

    public void login(String user, String password) throws LoginNotFoundException {

        loginInteractor.loginUser(user, password);
    }

    public void signup(String user, String pass, String contact, String question, String answer)
            throws InvalidPasswordException, IOException {

        signupInteractor.signUpUser(user, pass, contact, question, answer);
    }
}
