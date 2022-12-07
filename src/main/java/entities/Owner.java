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
     */
    public Owner(String ID, String name, String password, String contact, String hiredRealtorID,
                 ArrayList<Review> reviews) {
        super(ID, name, password, contact, hiredRealtorID);
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
     */
    public Owner(String ID, String name, String password, String contact, ArrayList<Review> reviews) {
        super(ID, name, password, contact);
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
