package interactors.input_boundary;

public interface CreateReviewInput {
    void createReview(String review, String rating, String userID, String ownerID);
}
