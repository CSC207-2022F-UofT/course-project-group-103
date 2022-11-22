package Users;

import Review.Review;

import java.util.ArrayList;

public class Owner extends User{
    private ArrayList<Review> reviews;

    public Owner(String ID, String name, String password, String contact, String hiredRealtorID, ArrayList<Review> reviews) {
        super(ID, name, password, contact, hiredRealtorID);
        this.reviews = reviews;
    }

    public Owner(String ID, String name, String password, String contact, ArrayList<Review> reviews) {
        super(ID, name, password, contact);
        this.reviews = reviews;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
