package Users;

import Review.Review;

import java.util.ArrayList;
import java.util.Objects;

public class Owner {
    private String name;
    private ArrayList<Review> reviews = new ArrayList<>();
    public Owner(String name){
        this.name = name;
    }

    public void setExtraReview(Review review){
        if (Objects.equals(review.getOwnerName(), this.name)) {
            this.reviews.add(review);
        }
    }

    public String getName(){
        return this.name;
    }

    public String getReviews(){
        ArrayList<String> reviewsStringArray= new ArrayList<>();
        for (Review review: this.reviews){
            reviewsStringArray.add(review.getReview());
        }
        return reviewsStringArray.toString();
    }



}
