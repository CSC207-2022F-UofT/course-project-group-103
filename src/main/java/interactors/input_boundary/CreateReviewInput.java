package interactors.input_boundary;

public interface CreateReviewInput {
    /**
     * Creates a review on a users account.
     *
     * @param review: content of the review.
     * @param rating: rating given with review.
     * @param userID: ID of review writer.
     * @param ownerID: ID of review receiver.
     */
    void createReview(String review, String rating, String userID, String ownerID);
}
