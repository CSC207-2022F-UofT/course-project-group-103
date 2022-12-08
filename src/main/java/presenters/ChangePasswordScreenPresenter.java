package presenters;

import entities.User;
import interactors.ChangePasswordInteractor;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.ChangePasswordInput;
import interactors.input_boundary.SignUpInput;
import interactors.output_boundary.ChangePasswordOutput;

import java.io.IOException;

public class ChangePasswordScreenPresenter implements ChangePasswordOutput {

    public ViewInterface viewInterface;
    public ChangePasswordInput changePasswordInput;

    public ChangePasswordScreenPresenter(ViewInterface viewInterface, LoginGateway loginGateway) {
        this.viewInterface = viewInterface;
        this.changePasswordInput = new ChangePasswordInteractor(loginGateway, this);
    }

    /**
     * Display the previous page.
     * <p>
     * Calls the presenter method displayPrevious() which is implemented in the GUI class.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    public void onBackInactive() {
        this.viewInterface.displayLogin();
    }

    public void onChangePassword(String user, String securityAnswer, String password) throws IOException, UndefinedUserType {
        this.changePasswordInput.changePassword(user, securityAnswer, password);
    }

    public void onWrongSecurityAnswer(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onChangePasswordSuccess(String message) {
        this.viewInterface.displaySuccess(message);
    }

    public String getUser() {
        return this.viewInterface.getActiveUser();
    }

    public String getSecurityQuestion(String id) throws IOException {
        if (id != null) {
            return this.changePasswordInput.getSecurityQuestion(id);
        } else {
            return "oops";
        }
    }

    public String getSecurityQuestion() throws IOException {
        if (getUser() != null) {
            return this.changePasswordInput.getSecurityQuestion(getUser());
        } else {
            return "oops";
        }
    }
}
