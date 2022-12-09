package interactors.output_boundary;

public interface CreateListingOutput {

    /**
     * Called when a listing was successfully created.
     */
    void onCreateListingSuccess();
    /**
     * Called when an attempt to create a listing was failed.
     *
     * @param message: failure message
     */
    void onCreateListingFailure(String message);
}
