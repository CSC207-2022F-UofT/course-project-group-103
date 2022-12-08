package interactors.gateway_interfaces;

import entities.Review;
import java.util.ArrayList;

public interface ReviewGateway {
    /**
     * Gets a list of reviews from the database.
     * @return Array list of reviews.
     */
    ArrayList<Review> getReviews();
    /**
     * Saves a review to the database
     *
     * @param r: review to save to the database.
     */
    void saveReview(Review r) throws Exception;
    /**
     * Deletes the review associated with the given ID from the database.
     *
     * @param id: ID of review to delete.
     */
    void deleteReview(String id) throws Exception;
}
