package managers;

import entities.Owner;
import entities.Realtor;
import entities.Review;
import interactors.gateway_interfaces.LoginGateway;
import entities.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginManager implements LoginGateway {

    /**
     * filepath to the user database.
     */
    String users_filepath;
    /**
     * filepath to the review database.
     */
    String reviews_filepath;

    /**
     * Constructor for a login manager, assigns the filepaths.
     *
     * @param u: filepath to the user database.
     * @param r: filepath to the review database.
     */
    public LoginManager(String u, String r) {
        this.users_filepath = u;
        this.reviews_filepath = r;
    }

    /**
     * @see LoginGateway
     * reads the user_listing json and reconstructs user objects from the information.
     */
    @Override
    public ArrayList<User> getUsers() {
        try {
            Path filePath = Path.of(this.users_filepath);
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            ArrayList<User> users = new ArrayList<>();
            for (String id: a.keySet()) {
                JSONObject j = a.getJSONObject(id);
                String name = j.getString("name");
                String password = j.getString("password");
                String contact = j.getString("contact");
                if (j.getString("user_type").equals("Owner")) {
                    JSONArray reviews = j.getJSONArray("reviews");
                    ArrayList<Review> review_list = new ArrayList<>();
                    for (Object r: reviews) {
                        review_list.add(this.getReview(r.toString()));
                    }
                    String hiredRealtorID = j.getString("hiredRealtor");
                    Owner o = new Owner(id, name, password, contact, hiredRealtorID, review_list);
                    users.add(o);
                } else if (j.getString("user_type").equals("Realtor")) {
                    Realtor r = new Realtor(id, name, password, contact);
                    users.add(r);
                } else {
                    String hiredRealtorID = j.getString("hiredRealtor");
                    User u = new User(id, name, password, contact, hiredRealtorID);
                    users.add(u);
                }
            }
            return users;
        } catch(Exception e) {e.printStackTrace(); return new ArrayList<>();}
    }

    /**
     * Reads the review json and reconstructs the review of the associated id.
     *
     * @param ID: ID of review to get.
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
     * @see LoginGateway
     * converts a user object into a json format and the reads the user_listing json placing the new
     * user json into the user_listing and save the file.
     */
    @Override
    public void saveUser(User u) throws Exception {
        JSONObject user = new JSONObject();
        String type = u.getClass().getName().replace("entities.", "");
        user.put("user_type", type);
        user.put("name", u.getName());
        user.put("password", u.getPassword());
        user.put("contact", u.getContact());
        if (!type.equals("Realtor")) {
            user.put("hiredRealtor", u.getHiredRealtorID());
        }
        if (type.equals("Owner")) {
            JSONArray reviews = new JSONArray();
            for (Review r: ((Owner) u).getReviews()) {
                reviews.put(r.getID());
            }
            user.put("reviews", reviews);
        }
        Path filePath = Path.of(this.users_filepath);
        String content = Files.readString(filePath);
        JSONObject user_list = new JSONObject(content);
        user_list.put(u.getID(),user);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.users_filepath)))) {
            writer.write(user_list.toString());
        }
    }

    /**
     * @see LoginGateway
     * reads the user_listing json and the removes the entry with the given ID as the key, then saves
     * the updated json back to the file.
     */
    @Override
    public void removeUser(String id) {
        try {
            Path filePath = Path.of(this.users_filepath);
            String content = Files.readString(filePath);
            JSONObject users = new JSONObject(content);
            users.remove(id);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.users_filepath)))) {
                writer.write(users.toString());
            }
        } catch (Exception e) {e.printStackTrace();}
    }

}
