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
            review.addReview();
        }
    }

    public static void main(String[] args) {
        User user1 = new User("John Mayer", "id5");
        User user2 = new User("Jack Dill", "id9");
        Owner owner = new Owner("Hope winters");
        Review review1 = new Review("This place was cool", owner, user1);
        Review review2 = new Review("the guy was not pleasant", owner, user2);
        addReviewNow(review1);
        addReviewNow(review2);
        System.out.println(owner.getReviews());
    }
}
