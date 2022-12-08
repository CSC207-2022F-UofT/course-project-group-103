package managers;

import entities.Review;
import interactors.gateway_interfaces.ReviewGateway;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReviewManager implements ReviewGateway {

    /**
     * Path to the review database.
     */
    String reviews_filepath;

    /**
     * Constructor that assigns the filepath.
     *
     * @param r: path to the review database.
     */
    public ReviewManager(String r) {
        this.reviews_filepath = r;
    }

    /**
     * @see ReviewGateway
     * Reads reviews json from file and reconstructs all entries into review objects and
     * returns them as a list.
     */
    @Override
    public ArrayList<Review> getReviews() {
        try {
            Path filePath = Path.of(this.reviews_filepath);
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            ArrayList<Review> reviews = new ArrayList<>();
            for (String id: a.keySet()) {
                Review r = this.getReview(id);
                reviews.add(r);
            }
            return reviews;
        } catch (Exception e) {e.printStackTrace(); return null;}
    }

    /**
     * Reads reviews json from file gets the entry with the given ID as a key and reconstructs
     * it into a review object.
     *
     * @param ID: id of review to get.
     * @return Review object associated with the id.
     */
    public Review getReview(String ID) throws IOException {
        String location = this.reviews_filepath;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject review_list = new JSONObject(content);
        JSONObject review = review_list.getJSONObject(ID);
        String reviewString = review.getString("review");
        String ownerID = review.getString("owner");
        String userID = review.getString("user");
        String date = review.getString("date");
        int rating = review.getInt("rating");
        return new Review(ID, reviewString, ownerID, userID, date, rating);
    }

    /**
     * @see ReviewGateway
     * Converts review object into json format and that saves it to the file.
     */
    @Override
    public void saveReview(Review r) throws Exception {
        try {
            JSONObject review = new JSONObject();
            review.put("review", r.getReview());
            review.put("owner", r.getOwner());
            review.put("user", r.getUser());
            review.put("date", r.getDate());
            review.put("rating", r.getRating());
            //
            Path filePath = Path.of(this.reviews_filepath);
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            a.put(r.getID(), review);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.reviews_filepath)))) {
                writer.write(a.toString());
            }
        }
        catch(Exception e) {throw new Exception("Save failed");}

    }

    /**
     * @see ReviewGateway
     * Reads the review file and then deletes the entry with the given id as a key before saving the
     * updated json object back to the file.
     */
    @Override
    public void deleteReview(String id) throws Exception {
        Path filePath = Path.of(this.reviews_filepath);
        String content = Files.readString(filePath);
        JSONObject a = new JSONObject(content);
        a.remove(id);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.reviews_filepath)))) {
            writer.write(a.toString());
        }
    }
}
