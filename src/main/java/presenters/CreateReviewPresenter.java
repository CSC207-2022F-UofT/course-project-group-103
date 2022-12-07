package presenters;

import interactors.CreateReviewInteractor;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.CreateReviewInput;
import interactors.output_boundary.CreateReviewOutput;

public class CreateReviewPresenter implements CreateReviewOutput {

    ViewInterface viewInterface;
    CreateReviewInput createReviewInput;

    public CreateReviewPresenter(ViewInterface view, ReviewGateway g) {
        this.viewInterface = view;
        this.createReviewInput = new CreateReviewInteractor(g, this);
    }

    public void onCreateReview(String content, String rating, String id) {
        this.createReviewInput.createReview(content, rating, this.viewInterface.getActiveUser(), id);
    }

    @Override
    public void onCreateReviewSuccess() {
        this.viewInterface.displaySuccess("Review created.");
        this.viewInterface.displayHome();
    }

    @Override
    public void onCreateReviewFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }
}
