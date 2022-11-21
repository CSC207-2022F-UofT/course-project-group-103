package Managers;

import Exceptions.UndefinedPropertyType;
import Properties.*;
import Review.Review;
import Users.Owner;
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
            JSONObject property = (JSONObject) property_listing.get(ID);
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
            if (property.get("property_type") == "Condo") {
                int numBedrooms = property.getInt("numBedrooms");
                int numBathrooms = property.getInt("numBathrooms");
                int numLaundry = property.getInt("numLaundry");
                int numKitchens = property.getInt("numKitchens");
                return new Condo(name, address, ID, (Owner) getUser(ownerID), sqFt, price, numBedrooms, numBathrooms, numLaundry, numKitchens);
            }
            if (property.get("property_type") == "Office") {
                int numOfficeRooms = property.getInt("numOfficeRooms");
                int numReceptions = property.getInt("numReceptions");
                return new Office(name, address, ID, (Owner) getUser(ownerID), sqFt, price, numOfficeRooms, numReceptions);
            }
            if (property.get("property_type") == "Restaurant") {
                String kitchenSpecifications = property.getString("kitchenSpecifications");
                return new Restaurant(name, address, ID, (Owner) getUser(ownerID), sqFt, price, kitchenSpecifications);
            }
            else {
                throw new UndefinedPropertyType(property.get("property_type") + " is not implemented as a property type yet.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String ID) throws IOException {
        String location = "/Users/zeinsulayman/IdeaProjects/course-project-group-103/src/main/Databases/UserListing.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject user_listing = new JSONObject(content);
        JSONObject user = (JSONObject) user_listing.get(ID);
        String name = user.getString("name");
        JSONArray reviews = user.getJSONArray("reviews");
        ArrayList<Review> review_list = new ArrayList<>();
        for (int i = 0; i < reviews.length(); i++) {
            review_list.add(getReview(reviews.getString(i)));
        }
        return new Owner(name, ID, review_list);
    }

    public static Review getReview(String ID) throws IOException {
        String location = "/Users/zeinsulayman/IdeaProjects/course-project-group-103/src/main/Databases/ReviewList.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject review_list = new JSONObject(content);
        JSONObject review = (JSONObject) review_list.get(ID);
        String reviewString = review.getString("review");
        String ownerID = review.getString("owner");
        String userID = review.getString("user");
        String date = review.getString("date");
        int rating = review.getInt("rating");
        return new Review(ID, reviewString, ownerID, userID, date, rating);
    }
}
