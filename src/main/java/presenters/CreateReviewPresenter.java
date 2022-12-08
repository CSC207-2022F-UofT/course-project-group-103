package presenters;

import interactors.CreateReviewInteractor;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.CreateReviewInput;
import interactors.output_boundary.CreateReviewOutput;

public class CreateReviewPresenter implements CreateReviewOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with use case.
     */
    CreateReviewInput createReviewInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the review gateway interface.
     */
    public CreateReviewPresenter(ViewInterface view, ReviewGateway g) {
        this.viewInterface = view;
        this.createReviewInput = new CreateReviewInteractor(g, this);
    }

    /**
     * Called when the user input create new review. Calls the create review input method create
     * review passing in all the parameters.
     *
     * @param content: content of the review
     * @param rating: rating given
     * @param id: id of the account being reviewed
     */
    public void onCreateReview(String content, String rating, String id) {
        this.createReviewInput.createReview(content, rating, this.viewInterface.getActiveUser(), id);
    }

    /**
     * @see CreateReviewOutput
     * Tells the view to display a success message and then go back to the previous page.
     */
    @Override
    public void onCreateReviewSuccess() {
        this.viewInterface.displaySuccess("Review created.");
        this.viewInterface.displayHome();
    }

    /**
     * @see CreateReviewOutput
     * Tells the view to display a failure message.
     */
    @Override
    public void onCreateReviewFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    /**
     * Called when the user input to go to the previous page is given. Tells the view
     * to display the previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }
}
