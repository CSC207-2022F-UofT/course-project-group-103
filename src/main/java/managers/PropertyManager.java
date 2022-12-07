package managers;

import exceptions.UndefinedPropertyType;
import exceptions.UndefinedUserType;
import entities.properties.*;
import entities.review.Review;
import entities.users.Owner;
import entities.users.Realtor;
import entities.users.User;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.io.PrintWriter;

public class PropertyManager {
    public static Property getProperty(String ID) throws UndefinedPropertyType {
        try {
            String location = "src/main/Databases/PropertyListing.json";
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
            reviews = user.getJSONArray("reviews");
            review_list = new ArrayList<>();
            for (int i = 0; i < reviews.length(); i++) {
                review_list.add(getReview(reviews.getString(i)));
            }
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                return new Owner(ID, name, password, contact, securityQuestion, securityAnswer, review_list);
            }
            else {
                String hiredRealtorID = user.getString("hiredRealtor");
                return new Owner(ID, name, password, contact, securityQuestion, securityAnswer, hiredRealtorID, review_list);
                // might be redundant code, I just removed the conflicts
                //Owner owner = new Owner(ID, name, password, contact, securityQuestion, securityAnswer);
                //owner.setReviews(review_list);
                //return owner;

            }
            //
            /* else {
                String hiredRealtorID = user.getString("hiredRealtor");
                Owner owner = new Owner(ID, name, password, contact, hiredRealtorID,securityQuestion, securityAnswer);
                owner.setReviews(review_list);
                return owner;
            } */
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


    public static float getPrice(String id) {
        try {
            String location = "src/main/Databases/PropertyListing.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject obj = new JSONObject(content);
            float price = obj.getJSONObject(id).getFloat("price");
            return price;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getPropertyType(String id) {
        try {
            String location = "src/main/Databases/PropertyListing.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject obj = new JSONObject(content);
            String ptype = obj.getJSONObject(id).getString("property_type");
            return ptype;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean getSold(String id) {
        try {
            String location = "src/main/Databases/PropertyListing.json";
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject obj = new JSONObject(content);
            String name = obj.getJSONObject(id).getString("sold");
            return name.equals("true");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void markSold(String id) throws IOException {
        String location = "src/main/Databases/PropertyListing.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject obj = new JSONObject(content);
        obj.getJSONObject(id).put("sold", "true");
        try (PrintWriter file2 = new PrintWriter(location)) {
            file2.write(obj.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}