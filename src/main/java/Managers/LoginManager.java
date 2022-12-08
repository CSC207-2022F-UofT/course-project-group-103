package managers;

import entities.Owner;
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
    String users_filepath;
    String reviews_filepath;

    public LoginManager(String u, String r) {
        this.users_filepath = u;
        this.reviews_filepath = r;
    }

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
                    Owner o = new Owner(id, name, password, contact, review_list);
                    users.add(o);
                }
                else {
                    User u = new User(id, name, password, contact);
                    users.add(u);
                }
            }
            return users;
        } catch(Exception e) {}
        return null;
    }

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

    public void saveUser(User u) throws Exception {
        JSONObject user = new JSONObject();
        String type = u.getClass().getName().replace("entities.", "");
        user.put("user_type", type);
        user.put("name", u.getName());
        user.put("password", u.getPassword());
        user.put("contact", u.getContact());
        // no realtor implementation yet
        user.put("hiredRealtor", "NA");
        if (type.equals("Owner")) {
            user.put("reviews", ((Owner) u).getReviews());
        }
        Path filePath = Path.of(this.users_filepath);
        String content = Files.readString(filePath);
        JSONObject user_list = new JSONObject(content);
        user_list.put(u.getID(),user);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.users_filepath), "utf-8"))) {
            writer.write(user_list.toString());
        }
    }

    public void removeUser(String id) {
        try {
            Path filePath = Path.of(this.users_filepath);
            String content = Files.readString(filePath);
            JSONObject users = new JSONObject(content);
            users.remove(id);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.users_filepath), "utf-8"))) {
                writer.write(users.toString());
            }
        } catch (Exception e) {e.printStackTrace();}
    }

}
