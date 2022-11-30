package Interactors;

import Review.Review;
import Users.Owner;
import Users.User;

public class Feature5Interactor {
    public static void addReviewNow (Review review){
        if(!review.calculateIfAppropriate()){
            System.out.println("This was not appropriate!");
        }
        else{
            review.newReview();
        }
    }

}
