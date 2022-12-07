package Interactors;

import Exceptions.InvalidPasswordException;

import java.io.IOException;

public class SignupInteractor {

    LoginDatabaseGateway gateway;

    public SignupInteractor(LoginDatabaseGateway g){
        this.gateway = g;
    }

    public void signUpUser(String user, String pass, String contact, String question, String answer)
            throws IOException, InvalidPasswordException {

        if(this.gateway.verifyPassword(pass)){
            this.gateway.addUser(user, pass, contact, question, answer);
        }else{
            throw new InvalidPasswordException("Invalid Password. Please re-enter your password so it " +
                    "fits the requirements");
        }
    }
}
