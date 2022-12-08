package entities;

import java.util.ArrayList;

public class Owner extends User{
    /**
     * List of reviews of the owner.
     */
    private final ArrayList<Review> reviews;

    /**
     * One of the constructor for owner class, assigns values to its attributes. This constructor
     * will assign a hiredRealtorID.
     *
     * @param ID: Unique ID of the owner.
     * @param name: Name of the owner.
     * @param password: Password of the owner.
     * @param contact: Contact information of the owner.
     * @param hiredRealtorID: ID of the owner's hired realtor.
     * @param reviews: Array list of reviews of the owner.
     * @param securityQuestion: Security Question chosen by the Owner.
     * @param securityAnswer: Security Answer chosen by the Owner.
     */
    public Owner(String ID, String name, String password, String contact, String hiredRealtorID,
                 ArrayList<Review> reviews, String securityQuestion, String securityAnswer) {
        super(ID, name, password, contact, hiredRealtorID, securityQuestion, securityAnswer);
        this.reviews = reviews;
    }

    /**
     * One of the constructor for owner class, assigns values to its attributes. This constructor
     * will not assign a hiredRealtorID.
     *
     * @param ID: Unique ID of the owner.
     * @param name: Name of the owner.
     * @param password: Password of the owner.
     * @param contact: Contact information of the owner.
     * @param reviews: Array list of reviews of the owner.
     * @param securityQuestion: Security Question chosen by the Owner.
     * @param securityAnswer: Security Answer chosen by the Owner.
     */
    public Owner(String ID, String name, String password, String contact, ArrayList<Review> reviews,
                 String securityQuestion, String securityAnswer) {
        super(ID, name, password, contact, securityQuestion, securityAnswer);
        this.reviews = reviews;
    }

    /**
     * Returns the list of reviews of the owner.
     * @return array list of review objects with each review one of the owner.
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }
}
