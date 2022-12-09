package interactors;

import entities.Review;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.CreateReviewInput;
import interactors.output_boundary.CreateReviewOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CreateReviewInteractor implements CreateReviewInput {

    /**
     * Gateway interface for the review's database.
     */
    ReviewGateway reviewGateway;
    /**
     * Output interface for this interactor.
     */
    CreateReviewOutput createReviewOutput;

    /**
     * Constructor for the interactor, assigns its attributes.
     *
     * @param g: implementation of the review gateway interface.
     * @param ob: implementation of the interacts output.
     */
    public CreateReviewInteractor(ReviewGateway g, CreateReviewOutput ob) {
        this.reviewGateway = g;
        this.createReviewOutput = ob;
    }

    /**
     * Checks if the review written is appropriate.
     *
     * @param review: content of the review.
     *
     * @return boolean of whether the review is free of inappropriate words or not
     */
    private boolean CheckIfAppropriate(String review){
        String[] review_words = review.split(" ");
        for(String word: review_words){
            if (this.reviewGateway.InappropriateWordsList().contains(word.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a review object associated with the accessed account and active user and saves it to the database.
     *
     * @param review: content of the review.
     * @param rating: rating given.
     * @param userID: ID of the user who wrote the review.
     * @param ownerID: ID of the owner who wrote the review.
     */
    @Override
    public void createReview(String review, String rating, String userID, String ownerID) {
        int rating_int;
        try {
            if (!CheckIfAppropriate(review)) {
                this.createReviewOutput.onCreateReviewFailure("Please refrain from using inappropriate language.");
                return;
            }
        }catch (Exception e)
        {this.createReviewOutput.onCreateReviewFailure("Inappropriate language detected."); return;}

            try {
                rating_int = Integer.parseInt(rating);
                if (rating_int > 5 || rating_int < 1) {
                    this.createReviewOutput.onCreateReviewFailure("Select an integer from 1-5 as a rating.");
                    return;
                }
        } catch (Exception e)
            {this.createReviewOutput.onCreateReviewFailure("Select an integer from 1-5 as a rating."); return;}

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Review r = new Review(this.getValidID(), review, ownerID,
                userID, dtf.format(now), rating_int);
        try {
            this.reviewGateway.saveReview(r);
        } catch (Exception e) {this.createReviewOutput.onCreateReviewFailure("Failed to save review."); return;}
        this.createReviewOutput.onCreateReviewSuccess();

    }

    /**
     * Searches the reviews in the review database to find the lowest unused ID.
     * @return string of the lowest unused ID.
     */
    private String getValidID() {
        ArrayList<Review> reviews = this.reviewGateway.getReviews();
        for (int i = 0; i < reviews.size(); i++) {
            for (int j = 0; j < reviews.size(); j++) {
                if (reviews.get(j).getID().equals(Integer.toString(i))) {
                    break;
                } else if (j == reviews.size()-1) {
                    return Integer.toString(i);
                }
            }
        }
        return Integer.toString(reviews.size());
    }
}
