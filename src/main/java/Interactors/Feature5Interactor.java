package Interactors;

import Entities.Review.Review;

public class Feature5Interactor {
    public static void addReviewNow (Review review){
        if(!review.calculateIfAppropriate(review.getReview())){
            System.out.println("This was not appropriate!");
        }
        else{
            review.newReview();
        }
    }

}
