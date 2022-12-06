package interactors.gateway_interfaces;

import entities.Review;
import java.util.ArrayList;

public interface ReviewGateway {
    ArrayList<Review> getReviews();
    void saveReview(Review r) throws Exception;
}
