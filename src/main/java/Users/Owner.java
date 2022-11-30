package Users;

import Review.Review;

import java.util.ArrayList;


public class Owner extends User{
    private ArrayList<Review> reviews;

    public Owner(String ID, String name, String password, String contact, String hiredRealtorID, String securityQuestion, String securityAnswer) {
        super(ID, name, password, contact, hiredRealtorID, securityQuestion, securityAnswer);
        this.reviews = new ArrayList<>();
    }

    public Owner(String ID, String name, String password, String contact, String securityQuestion, String securityAnswer){
        super(ID, name, password, contact, securityQuestion, securityAnswer);
        this.reviews = new ArrayList<>();
    }


    public void addReview(Review review){
        this.reviews.add(review);
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

}



