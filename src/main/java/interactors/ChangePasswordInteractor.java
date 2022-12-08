package interactors;

import entities.User;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.ChangePasswordInput;
import interactors.output_boundary.ChangePasswordOutput;

import java.io.IOException;

public class ChangePasswordInteractor implements ChangePasswordInput {
    /**
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;
    ChangePasswordOutput changePasswordOutput;

    public ChangePasswordInteractor(LoginGateway loginGateway, ChangePasswordOutput changePasswordOutput) {
        this.loginGateway = loginGateway;
        this.changePasswordOutput = changePasswordOutput;
    }

    public void changePassword(String user_id, String securityAnswer, String newPassword) throws IOException,
            UndefinedUserType {
        User user = this.loginGateway.getUser(user_id);
        if (user.getSecurityAnswer().equals(securityAnswer)) {
            this.loginGateway.savePassword(user, newPassword);
            this.changePasswordOutput.onChangePasswordSuccess("You have successfully changed your password!");
        }
        else {
            this.changePasswordOutput.onWrongSecurityAnswer("This security answer is not correct.");
        }
    }

    public String getSecurityQuestion(String user_id) throws IOException {
        return this.loginGateway.getSecurityQuestion(user_id);
    }

}
