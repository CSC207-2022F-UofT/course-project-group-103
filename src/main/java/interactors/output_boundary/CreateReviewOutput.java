package interactors.output_boundary;

public interface CreateReviewOutput {

    /**
     * Called when a review was successfully created.
     */
    void onCreateReviewSuccess();
    /**
     * Called when an attempt to create a listing was failed.
     *
     * @param message: failure message
     */
    void onCreateReviewFailure(String message);
}
