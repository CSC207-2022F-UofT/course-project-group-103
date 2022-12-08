package presenters;

import interactors.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.AccessPropertyInput;
import interactors.input_boundary.ChangePasswordInput;
import interactors.input_boundary.DeleteAccountInput;
import interactors.output_boundary.AccessPropertyOutput;
import interactors.output_boundary.DeleteAccountOutput;

import java.io.IOException;

public class ActiveAccountPresenter implements AccessPropertyOutput, DeleteAccountOutput{

    ViewInterface viewInterface;
    AccessPropertyInput accessPropertyInput;
    DeleteAccountInput deleteAccountInput;
    ChangePasswordInput changePasswordInput;

    public ActiveAccountPresenter(ViewInterface view, PropertyGateway g, LoginGateway lg, ReviewGateway rg) {
        this.viewInterface = view;
        this.accessPropertyInput = new AccessPropertyInteractor(g, lg, this);
        this.deleteAccountInput = new DeleteAccountInteractor(g, lg, rg, this);
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    public void onAccessProperty(String id) {
        this.accessPropertyInput.accessProperty(id);
    }

    public void onAccessPropertySuccess(PropertyModel property) {
        this.viewInterface.displayProperty(property);
    }

    public void onAccessPropertyFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onSignOut() {
        this.viewInterface.setActiveUser(null);
        this.viewInterface.displayLogin();
    }

    public void onDeleteAccount(String password) {
        this.deleteAccountInput.deleteAccount(this.viewInterface.getActiveUser(), password);
    }

    public void onDeleteAccountSuccess() {
        this.viewInterface.setActiveUser(null);
        this.viewInterface.displayLogin();
    }

    public void onDeleteAccountFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onOpenChangePassword(String securityQuestion) throws IOException {
        this.viewInterface.displayChangePassword(securityQuestion);
    }
}
