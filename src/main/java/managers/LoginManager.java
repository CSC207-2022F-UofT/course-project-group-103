package managers;

import entities.Owner;
import entities.Realtor;
import entities.Review;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import entities.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

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
                users.add(getUser(id));
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
        user.put("securityQuestion", u.getSecurityQuestion());
        user.put("securityAnswer", u.getSecurityAnswer());
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
                new FileOutputStream(this.users_filepath), StandardCharsets.UTF_8))) {
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
                    new FileOutputStream(this.users_filepath), StandardCharsets.UTF_8))) {
                writer.write(users.toString());
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    /**
     * Returns the realtor with the associated ID.
     *
     * @param ID: ID of the user to return
     * @return The user with the associated ID
     */

    public Realtor getRealtor(String ID) throws IOException {
        String jsonString = Files.readString(Paths.get("src\\main\\Databases\\UserListing.json"));
        JSONObject obj = new JSONObject(jsonString);
        JSONObject info = (JSONObject) obj.get(ID);

        if (info.getString("user_type").equals("Realtor")) {
            String name = info.getString("name");
            String password = info.getString("password");
            String contact = info.getString("contact");
            String securityQuestion = info.getString("securityQuestion");
            String securityAnswer = info.getString("securityAnswer");

            return new Realtor(ID, name, password, contact,
                    securityQuestion, securityAnswer);
        }
        return null;
    }

    public void savePassword(User user, String newPassword) throws IOException {
        Path filePath = Path.of(this.users_filepath);
        String content = Files.readString(filePath);
        JSONObject user_list = new JSONObject(content);
        JSONObject user_dict = user_list.getJSONObject(user.getID());
        user_dict.put("password", newPassword);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.users_filepath), StandardCharsets.UTF_8))) {
            writer.write(user_list.toString());
        }
    }

    public User getUser(String ID) throws IOException, UndefinedUserType {
        String location = this.users_filepath;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject user_listing = new JSONObject(content);
        JSONObject user = user_listing.getJSONObject(ID);
        String name = user.getString("name");
        String password = user.getString("password");
        String contact = user.getString("contact");
        String securityQuestion = user.getString("securityQuestion");
        String securityAnswer = user.getString("securityAnswer");

        if (Objects.equals(user.get("user_type").toString(), "Owner")) {
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                JSONArray reviews = user.getJSONArray("reviews");
                ArrayList<Review> review_list = new ArrayList<>();
                for (int i = 0; i < reviews.length(); i++) {
                    review_list.add(this.getReview(reviews.getString(i)));
                }
                return new Owner(ID, name, password, contact, review_list, securityQuestion, securityAnswer);
            }
            else {
                JSONArray reviews = user.getJSONArray("reviews");
                ArrayList<Review> review_list = new ArrayList<>();
                for (int i = 0; i < reviews.length(); i++) {
                    review_list.add(this.getReview(reviews.getString(i)));
                }
                String hiredRealtorID = user.getString("hiredRealtor");
                return new Owner(ID, name, password, contact, hiredRealtorID, review_list, securityQuestion, securityAnswer);
            }
        }
        else if (Objects.equals(user.get("user_type").toString(), "User")) {
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                return new User(ID, name, password, contact, securityQuestion, securityAnswer);
            }
            else {
                String hiredRealtorID = user.getString("hiredRealtor");
                return new User(ID, name, password, contact, hiredRealtorID, securityQuestion, securityAnswer);
            }
        }
        else if (Objects.equals(user.get("user_type").toString(), "Realtor")) {
            return new Realtor(ID, name, password, contact, securityQuestion, securityAnswer);
        }
        else {
            throw new UndefinedUserType((user.getString("user_type") + " is not implemented as a user type yet."));
        }
    }

    public String getSecurityQuestion(String user_id) throws IOException {
        String location = this.users_filepath;
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject user_listing = new JSONObject(content);
        JSONObject user = user_listing.getJSONObject(user_id);
        return user.getString("securityQuestion");
    }


//
//    public boolean verifyPassword(String password) {
//        int passLength = 8;
//        char[] passArray = password.toCharArray();
//        boolean length = false;
//        boolean caps = false;
//        boolean number = false;
//
//        if(password.length() >= passLength)
//            length = true;
//
//        for (char c : passArray) {
//            if (Character.isUpperCase(c)) {
//                caps = true;
//                break;
//            }
//
//        }
//
//        for (char c : passArray) {
//            if (Character.isDigit(c)) {
//                number = true;
//                break;
//            }
//        }
//
//        return length && caps && number;
//
//    }
//
//    /**
//    * Displays and alert on the sign-up or login page.
//    * Displays an alert for invalid passwords, successfully made accounts, passwords not matching during sign-up
//    * password verification, etc.
//    */
//
//    public void displayAlert () {
//
//    }
}
