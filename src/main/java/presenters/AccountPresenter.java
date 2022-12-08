package presenters;

import interactors.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.AccessPropertyInput;
import interactors.input_boundary.LoadAccountInput;
import interactors.output_boundary.AccessPropertyOutput;
import interactors.output_boundary.CreateReviewOutput;
import interactors.output_boundary.LoadAccountOutput;

import java.util.ArrayList;

public class AccountPresenter implements AccessPropertyOutput {

    ViewInterface viewInterface;
    AccessPropertyInput accessPropertyInput;

    public AccountPresenter(ViewInterface view, PropertyGateway g, LoginGateway lg) {
        this.viewInterface = view;
        this.accessPropertyInput = new AccessPropertyInteractor(g, lg, this);
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

    public void onAddReview(String id) {
        this.viewInterface.displayCreateReview(id);
    }
}
