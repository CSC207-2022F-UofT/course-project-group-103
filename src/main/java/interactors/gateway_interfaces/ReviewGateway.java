package interactors.gateway_interfaces;

import entities.Review;
import java.util.ArrayList;
import java.util.Set;

public interface ReviewGateway {
    ArrayList<Review> getReviews();
    void saveReview(Review r) throws Exception;
    Set<String> InappropriateWordsList();
    void deleteReview(String id) throws Exception;
}
