package Review;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Set;
import java.time.format.DateTimeFormatter;

import Exceptions.UndefinedUserType;
import Managers.PropertyManager;
import org.json.JSONObject;
import Users.Owner;


public class Review {

    private final String ID;
    private String review;
    private final String ownerID;
    private final String  userID;
    private final String date;
    private int rating;

    public Review(String ID, String review, String ownerID, String userID, int rating) {
        this.ID = ID;
        this.review = review;
        this.ownerID = ownerID;
        this.userID = userID;
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.date = dateformat.format(now);

        this.rating = rating;
    }
    public Review(String ID, String review, String ownerID, String userID, String date, int rating) {
        this.ID = ID;
        this.review = review;
        this.ownerID = ownerID;
        this.userID = userID;
        this.date = date;
        this.rating = rating;
    }

    public static boolean calculateIfAppropriate(String sentence){
        try {
            String location = "_en.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject json = new JSONObject(content);
            Set<String> banned_words = json.keySet();
            String[] review_words = sentence.split(" ");
            for(String word: review_words){
                if (banned_words.contains(word)){
                    return false;
                }
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return true;
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
    public void newReview(){

        try {
            String location = "src/main/Databases/ReviewList.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject newReview = new JSONObject(content);
            JSONObject newReviewDetails = new JSONObject();
            newReviewDetails.put("owner", this.ownerID);
            newReviewDetails.put("user", this.userID);
            newReviewDetails.put("review", this.review);
            newReviewDetails.put("date", this.date);
            newReviewDetails.put("rating", this.rating);
            newReview.put(this.ID, newReviewDetails);
            try (PrintWriter file2 = new PrintWriter(location)) {
                file2.write(newReview.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
            Owner owner = (Owner) PropertyManager.getUser(this.ownerID);
            owner.addReview(this);

        } catch (IOException | UndefinedUserType e) {e.printStackTrace();}
    }


}
