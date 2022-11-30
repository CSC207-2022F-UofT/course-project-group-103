package Managers;

import Exceptions.UndefinedPropertyType;
import Exceptions.UndefinedUserType;
import Properties.*;
import Review.Review;
import Users.Owner;
import Users.Realtor;
import Users.User;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class PropertyManager {
    public static Property getProperty(String ID) throws UndefinedPropertyType {
        try {
            String location = "/Users/zeinsulayman/IdeaProjects/course-project-group-103/src/main/Databases/PropertyListing.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject property_listing = new JSONObject(content);
            JSONObject property = property_listing.getJSONObject(ID);
            String name = property.getString("name");
            String address = property.getString("address");
            String ownerID = property.getString("owner");
            int sqFt = property.getInt("sqFt");
            float price = property.getFloat("price");
            if (Objects.equals(property.get("property_type").toString(), "House")) {
                int numBedrooms = property.getInt("numBedrooms");
                int numBathrooms = property.getInt("numBathrooms");
                int numLaundry = property.getInt("numLaundry");
                int numKitchens = property.getInt("numKitchens");
                return new House(name, address, ID, (Owner) getUser(ownerID), sqFt, price, numBedrooms, numBathrooms, numLaundry, numKitchens);
            }
            if (Objects.equals(property.get("property_type").toString(), "Condo")) {
                int numBedrooms = property.getInt("numBedrooms");
                int numBathrooms = property.getInt("numBathrooms");
                int numLaundry = property.getInt("numLaundry");
                int numKitchens = property.getInt("numKitchens");
                return new Condo(name, address, ID, (Owner) getUser(ownerID), sqFt, price, numBedrooms, numBathrooms, numLaundry, numKitchens);
            }
            if (Objects.equals(property.get("property_type").toString(), "Office")) {
                int numOfficeRooms = property.getInt("numOfficeRooms");
                int numReceptions = property.getInt("numReceptions");
                return new Office(name, address, ID, (Owner) getUser(ownerID), sqFt, price, numOfficeRooms, numReceptions);
            }
            if (Objects.equals(property.get("property_type").toString(), "Restaurant")) {
                String kitchenSpecifications = property.getString("kitchenSpecifications");
                return new Restaurant(name, address, ID, (Owner) getUser(ownerID), sqFt, price, kitchenSpecifications);
            }
            else {
                throw new UndefinedPropertyType(property.get("property_type") + " is not implemented as a property type yet.");
            }
        } catch (IOException | UndefinedUserType e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String ID) throws IOException, UndefinedUserType {
        String location = "src/main/Databases/UserListing.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject user_listing = new JSONObject(content);
        JSONObject user = user_listing.getJSONObject(ID);
        String name = user.getString("name");
        String password = user.getString("password");
        String contact = user.getString("contact");
        String securityQuestion = user.getString("securityQuestion");
        String securityAnswer = user.getString("securityAnswer");
        JSONArray reviews = user.getJSONArray("reviews");
        ArrayList<Review> review_list = new ArrayList<>();
        for (int i = 0; i < reviews.length(); i++) {
            review_list.add(getReview(reviews.getString(i)));
        }
        if (Objects.equals(user.get("user_type").toString(), "Owner")) {
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                Owner owner = new Owner(ID, name, password, contact, securityQuestion, securityAnswer);
                owner.setReviews(review_list);
                return owner;

            }
            else {
                String hiredRealtorID = user.getString("hiredRealtor");
                Owner owner = new Owner(ID, name, password, contact, hiredRealtorID,securityQuestion, securityAnswer);
                owner.setReviews(review_list);
                return owner;
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

    public static Review getReview(String ID) throws IOException {
        String location = "src/main/Databases/ReviewList.json";
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


}
