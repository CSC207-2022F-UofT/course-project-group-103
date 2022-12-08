package interactors.input_boundary;

import entities.User;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;

public interface ChangePasswordInput {
    void changePassword(String user, String securityAnswer, String newPassword) throws IOException, UndefinedUserType;
    String getSecurityQuestion(String user) throws IOException;
}
