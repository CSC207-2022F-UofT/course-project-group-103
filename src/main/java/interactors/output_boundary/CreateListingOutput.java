package interactors.output_boundary;

public interface CreateListingOutput {
    void onCreateListingSuccess();
    void onCreateListingFailure(String message);
}
