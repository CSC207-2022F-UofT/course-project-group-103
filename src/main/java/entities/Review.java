package entities;

public class Review {

    /**
     * Unique ID of the review.
     */
    private final String ID;
    /**
     * Content of the review.
     */
    private final String review;
    /**
     * ID of the owner class who the review is of.
     */
    private final String ownerID;
    /**
     * ID of the user class who wrote the review.
     */
    private final String  userID;
    /**
     * Date the review was written.
     */
    private final String date;
    /**
     * Rating given with the review.
     */
    private final int rating;

    /**
     * Constructor for review class, assigns values to its attributes.
     *
     * @param ID: Unique ID of the review.
     * @param review: Content of the review.
     * @param ownerID: ID of owner who review is on.
     * @param userID: ID of user who left the review.
     * @param date: date of review.
     * @param rating: rating given with review.
     */
    public Review(String ID, String review, String ownerID, String userID, String date, int rating) {
        this.ID = ID;
        this.review = review;
        this.ownerID = ownerID;
        this.userID = userID;
        this.date = date;
        this.rating = rating;
    }

    /**
     * Returns the ID of the review.
     * @return string representation of the ID of review.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the content of the review.
     * @return string representation of the review content.
     */
    public String getReview() {
        return this.review;
    }

    /**
     * Returns the ID of the owner who the review is of.
     * @return string representation of owner ID.
     */
    public String getOwner() {
        return this.ownerID;
    }

    /**
     * Returns the ID of the user who wrote the review.
     * @return string representation of user ID.
     */
    public String getUser() {
        return this.userID;
    }

    /**
     * Returns the date the review was written.
     * @return string representation of date.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Returns the rating given with the review.
     * @return integer of rating.
     */
    public int getRating() {
        return this.rating;
    }
}
