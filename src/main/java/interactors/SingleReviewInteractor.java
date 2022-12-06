package interactors;

import entities.Review;
import entities.User;
import interactors.gateway_interfaces.PropertyGateway;

import java.util.ArrayList;

public class SingleReviewInteractor {

    /**
     * Review associated with listing.
     */
    Review review;
    /**
     * Gateway interface to property JSON with read/write methods.
     */
    PropertyGateway propertyGateway;

    /**
     * Constructor for the single-review interactor, assigns object instances to its attributes.
     *
     * @param r: review instance associated with this single review interactor.
     * @param g: implementation of propertyGateway interface.
     */
    public SingleReviewInteractor(Review r, PropertyGateway g) {
        this.review = r;
        this.propertyGateway = g;
    }

    /**
     * Returns an Array List of all relevant attributes of the review.
     * @return Array List of formatted string representations of the review information.
     */
    public ArrayList<String> reviewInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Rating: " + this.review.getRating() + "/5");
        info.add("Review: " + this.review.getReview());
        info.add("Date: " + this.review.getDate());
        try {
            User user = this.propertyGateway.getUser(this.review.getUser());
            info.add("By: " + user.getName());
        } catch (Exception e) {return info;}
        return info;
    }

}
