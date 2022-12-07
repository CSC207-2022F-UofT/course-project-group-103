package interactors.output_boundary;

public interface CreateReviewOutput {
    void onCreateReviewSuccess();
    void onCreateReviewFailure(String message);
}
