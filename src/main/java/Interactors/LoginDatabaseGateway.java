package Interactors;

import Users.User;
import org.json.JSONObject;

import java.io.IOException;

public interface LoginDatabaseGateway {

    JSONObject checkDatabase();

    void addUser(String name, String password, String contact, String securityQuestion,
                        String securityAnswer) throws IOException;

    boolean verifyPassword(String password);
}
