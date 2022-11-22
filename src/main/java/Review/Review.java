package Review;

public class Review {

    private final String ID;
    private String review;
    private final String ownerID;
    private final String  userID;
    private final String date;
    private int rating;

    public Review(String ID, String review, String ownerID, String userID, String date, int rating) {
        this.ID = ID;
        this.review = review;
        this.ownerID = ownerID;
        this.userID = userID;
        this.date = date;
        this.rating = rating;
    }

    public String getID() {
        return ID;
    }

    public String getReview() {
        return this.review;
    }

    public String getOwner() {
        return this.ownerID;
    }

    public String getUser() {
        return this.userID;
    }

    public String getDate() {
        return this.date;
    }

    public int getRating() {
        return this.rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
