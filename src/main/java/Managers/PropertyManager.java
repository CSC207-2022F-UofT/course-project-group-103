package Managers;

import Exceptions.UndefinedPropertyType;
import Exceptions.UndefinedUserType;
import Properties.*;
import Interactors.PropertyListingGateway;
import Review.Review;
import Users.Owner;
import Users.Realtor;
import Users.User;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class PropertyManager implements PropertyListingGateway {
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
        String location = "/Users/zeinsulayman/IdeaProjects/course-project-group-103/src/main/Databases/UserListing.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject user_listing = new JSONObject(content);
        JSONObject user = user_listing.getJSONObject(ID);
        String name = user.getString("name");
        String password = user.getString("password");
        String contact = user.getString("contact");
        JSONArray reviews = user.getJSONArray("reviews");
        ArrayList<Review> review_list = new ArrayList<>();
        for (int i = 0; i < reviews.length(); i++) {
            review_list.add(getReview(reviews.getString(i)));
        }
        if (Objects.equals(user.get("user_type").toString(), "Owner")) {
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                return new Owner(ID, name, password, contact, review_list);
            }
            else {
                String hiredRealtorID = user.getString("hiredRealtor");
                return new Owner(ID, name, password, contact, hiredRealtorID, review_list);
            }
        }
        else if (Objects.equals(user.get("user_type").toString(), "User")) {
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                return new User(ID, name, password, contact);
            }
            else {
                String hiredRealtorID = user.getString("hiredRealtor");
                return new User(ID, name, password, contact, hiredRealtorID);
            }
        }
        else if (Objects.equals(user.get("user_type").toString(), "Realtor")) {
            return new Realtor(ID, name, password, contact);
        }
        else {
            throw new UndefinedUserType((user.getString("user_type") + " is not implemented as a user type yet."));
        }
    }

    public static Review getReview(String ID) throws IOException {
        String location = "/Users/zeinsulayman/IdeaProjects/course-project-group-103/src/main/Databases/ReviewList.json";
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
     * Implements the save method of the PropertyListingGateway for dependency inversion. This is a temporary
     * implementation just so that bidding can work it is probably not a good way of doing this.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    public void save(Property p) {
        try {
            //
            JSONObject prop = new JSONObject();
            prop.put("property_type", p.getType());
            prop.put("name", p.getName());
            prop.put("address", p.getAddress());
            prop.put("owner", p.getOwner().getID());
            prop.put("sqFt", p.getSqFt());
            prop.put("price", p.getPrice());
            prop.put("bids", p.getBids());
            if (p.getType().equals("Condo")) {
                prop.put("numBedrooms", ((Condo) p).getNumBedrooms());
                prop.put("numBathrooms", ((Condo) p).getNumBathrooms());
                prop.put("numKitchens", ((Condo) p).getNumKitchen());
                prop.put("numLaundry", ((Condo) p).getNumLaundry());
            }
            else if (p.getType().equals("House")) {
                prop.put("numBedrooms", ((House) p).getNumBedrooms());
                prop.put("numBathrooms", ((House) p).getNumBathrooms());
                prop.put("numKitchens", ((House) p).getNumKitchen());
                prop.put("numLaundry", ((House) p).getNumLaundry());
            }
            else if (p.getType().equals("Office")) {
                prop.put("numOfficeRooms", ((Office) p).getNumOfficeRooms());
                prop.put("numReceptions", ((Office) p).getNumReceptions());
            }
            else if (p.getType().equals("Restaurant")) {
                prop.put("kitchen_specifications", ((Restaurant) p).getKitchenSpecifications());
            }
            //
            Path filePath = Path.of("src/main/Databases/PropertyListing.json");
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            a.put(p.getID(), prop);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("src/main/Databases/PropertyListing.json"), "utf-8"))) {
                writer.write(a.toString());
            }
        } catch(Exception e) {}
    }
}
