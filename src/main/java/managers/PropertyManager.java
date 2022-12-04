package managers;

import entities.UndefinedPropertyType;
import entities.UndefinedUserType;
import entities.*;
import interactors.PropertyListingGateway;
import entities.Owner;
import entities.Realtor;
import entities.User;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PropertyManager implements PropertyListingGateway {
    String properties_filepath;
    String users_filepath;
    String reviews_filepath;

    public PropertyManager(String p, String u, String r) {
        this.properties_filepath = p;
        this.users_filepath = u;
        this.reviews_filepath = r;
    }

    public Property getProperty(String ID) throws UndefinedPropertyType {
        try {
            String location = this.properties_filepath;
            File file = new File(location);
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject property_listing = new JSONObject(content);
            JSONObject property = property_listing.getJSONObject(ID);
            String name = property.getString("name");
            String address = property.getString("address");
            String ownerID = property.getString("owner");
            int sqFt = property.getInt("sqFt");
            float price = property.getFloat("price");
            HashMap<String, Float> bids = this.parseBids(property.getJSONObject("bids"));
            if (Objects.equals(property.get("property_type").toString(), "House")) {
                int numBedrooms = property.getInt("numBedrooms");
                int numBathrooms = property.getInt("numBathrooms");
                int numLaundry = property.getInt("numLaundry");
                int numKitchens = property.getInt("numKitchens");
                return new House(name, address, ID, (Owner) this.getUser(ownerID), sqFt, price,
                        numBedrooms, numBathrooms, numLaundry, numKitchens, bids);
            }
            if (Objects.equals(property.get("property_type").toString(), "Condo")) {
                int numBedrooms = property.getInt("numBedrooms");
                int numBathrooms = property.getInt("numBathrooms");
                int numLaundry = property.getInt("numLaundry");
                int numKitchens = property.getInt("numKitchens");
                return new Condo(name, address, ID, (Owner) this.getUser(ownerID), sqFt, price,
                        numBedrooms, numBathrooms, numLaundry, numKitchens, bids);
            }
            if (Objects.equals(property.get("property_type").toString(), "Office")) {
                int numOfficeRooms = property.getInt("numOfficeRooms");
                int numReceptions = property.getInt("numReceptions");
                return new Office(name, address, ID, (Owner) this.getUser(ownerID), sqFt, price,
                        numOfficeRooms, numReceptions, bids);
            }
            if (Objects.equals(property.get("property_type").toString(), "Restaurant")) {
                String kitchenSpecifications = property.getString("kitchenSpecifications");
                return new Restaurant(name, address, ID, (Owner) this.getUser(ownerID), sqFt, price,
                        kitchenSpecifications, bids);
            }
            else {
                throw new UndefinedPropertyType(property.get("property_type") + " is not implemented as a property type yet.");
            }
        } catch (IOException | UndefinedUserType e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Float> parseBids(JSONObject j) {
        HashMap<String, Float> bids = new HashMap<>();
        for (String s: j.keySet()) {
            bids.put(s, j.getFloat(s));
        }
        return bids;
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
        if (Objects.equals(user.get("user_type").toString(), "Owner")) {
            if (Objects.equals(user.get("hiredRealtor"), null)) {
                JSONArray reviews = user.getJSONArray("reviews");
                ArrayList<Review> review_list = new ArrayList<>();
                for (int i = 0; i < reviews.length(); i++) {
                    review_list.add(this.getReview(reviews.getString(i)));
                }
                return new Owner(ID, name, password, contact, review_list);
            }
            else {
                JSONArray reviews = user.getJSONArray("reviews");
                ArrayList<Review> review_list = new ArrayList<>();
                for (int i = 0; i < reviews.length(); i++) {
                    review_list.add(this.getReview(reviews.getString(i)));
                }
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
     * Implements the save method of the PropertyListingGateway for dependency inversion.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    public void save(Property p) throws Exception {
        try {
            // property object to JSON object:
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
                prop.put("kitchenSpecifications", ((Restaurant) p).getKitchenSpecifications());
            }
            //
            Path filePath = Path.of(this.properties_filepath);
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            a.put(p.getID(), prop);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.properties_filepath), "utf-8"))) {
                writer.write(a.toString());
            }
        } catch(Exception e){
            throw new Exception("Save failed.");
        }
    }

    public ArrayList<Property> getProperties() {
        try {
            Path filePath = Path.of(this.properties_filepath);
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            ArrayList<Property> properties = new ArrayList<>();
            for (String id: a.keySet()) {
                Property p = this.getProperty(id);
                properties.add(p);
            }
            return properties;
        } catch (Exception e) {e.printStackTrace(); return null;}
    }
}
