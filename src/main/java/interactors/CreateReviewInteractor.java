package interactors;

import entities.Review;
import interactors.containers.AccountToDisplay;
import interactors.containers.ActiveUser;
import interactors.gateway_interfaces.ReviewGateway;
import managers.ReviewManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CreateReviewInteractor {

    /**
     * Gateway interface to review JSON with read/write methods.
     */
    ReviewGateway reviewGateway;
    /**
     * Current user of the application.
     */
    ActiveUser activeUser;
    /**
     * Current account being accessed.
     */
    AccountToDisplay accountToDisplay;

    /**
     * Constructor for the create-review interactor, assigns object instances to its attributes.
     *
     * @param g: implementation of propertyGateway interface.
     * @param u: ActiveUser class for this application instance's current active user.
     * @param a: AccountToDisplay class for this application instance's account being accessed.
     */
    public CreateReviewInteractor(ReviewManager g, ActiveUser u, AccountToDisplay a) {
        this.reviewGateway = g;
        this.activeUser = u;
        this.accountToDisplay = a;
    }

    /**
     * Creates a review object associated with the accessed account and active user and saves it to the database.
     *
     * @param review: content of the review.
     * @param rating: rating given.
     *
     * @throws Exception: failed to create the review.
     */
    public void createReview(String review, String rating) throws Exception {
        int rating_int;
        try {
            rating_int = Integer.parseInt(rating);
            if (rating_int > 5 || rating_int < 1) {
                throw new Exception();
            }
        } catch (Exception e) {throw new Exception("Enter an integer 1-5 for rating.");}
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Review r = new Review(this.getValidID(), review, this.accountToDisplay.getAccountDisplay().getID(),
                this.activeUser.getActiveUser().getID(), dtf.format(now), rating_int);
        this.reviewGateway.saveReview(r);
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
