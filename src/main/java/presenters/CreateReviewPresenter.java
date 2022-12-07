package presenters;

import interactors.CreateReviewInteractor;

public class CreateReviewPresenter {

    CreateReviewInteractor createReviewInteractor;
    ViewInterface viewInterface;

    public CreateReviewPresenter(CreateReviewInteractor i, ViewInterface p) {
        this.createReviewInteractor = i;
        this.viewInterface = p;
    }

    /**
     * Sends the create review request to the create-review interactor.
     *
     * Calls the active account interactor method createReview() and then calls the presenter methods
     * refreshAccount() and displayPrevious() if successful
     *
     * @param review: String representation of the review given by user
     * @param rating: String representation of the rating given by user
     * @throws Exception: failed to create review
     */
    public void onCreateReview(String review, String rating) throws Exception {
        this.createReviewInteractor.createReview(review, rating);
        // if create review does not throw an exception
        this.viewInterface.refreshAccount();
        this.viewInterface.displayPrevious();
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }
}
