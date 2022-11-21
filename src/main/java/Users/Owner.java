package Users;

import Review.Review;

import java.util.ArrayList;

public class Owner extends User{
    private String name;
    private final String ID;
    private ArrayList<Review> reviews;

    public Owner(String name, String ID, ArrayList<Review> reviews) {
        this.name = name;
        this.ID = ID;
        this.reviews = reviews;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
