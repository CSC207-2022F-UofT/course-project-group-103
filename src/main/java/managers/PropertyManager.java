package managers;

import interactors.exceptions.UndefinedPropertyType;
import interactors.exceptions.UndefinedUserType;
import entities.*;
import interactors.gateway_interfaces.PropertyGateway;
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

public class PropertyManager implements PropertyGateway {

    /**
     * Path to the property database.
     */
    String properties_filepath;
    /**
     * Path to the user database.
     */
    String users_filepath;
    /**
     * Path to the review database.
     */
    String reviews_filepath;
    LoginManager loginManager;

    /**
     * Constructor for a property manager, assigns the file paths.
     *
     * @param p: filepath to property database.
     * @param u: filepath to user database.
     * @param r: filepath to review database.
     */
    public PropertyManager(String p, String u, String r, LoginManager loginManager) {
        this.properties_filepath = p;
        this.users_filepath = u;
        this.reviews_filepath = r;
        this.loginManager = loginManager;
    }

    /**
     * Gets the property object with the associated id saved in the database.
     * Reads the database and retrieves the entry with a key equal to the id and then
     * reconstructs the property object from the information.
     *
     * @return property object of the given id.
     * @param ID: id of property to get.
     */
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
                return new House(name, address, ID, (Owner) loginManager.getUser(ownerID), sqFt, price,
                        numBedrooms, numBathrooms, numLaundry, numKitchens, bids);

            }
            if (Objects.equals(property.get("property_type").toString(), "Condo")) {
                int numBedrooms = property.getInt("numBedrooms");
                int numBathrooms = property.getInt("numBathrooms");
                int numLaundry = property.getInt("numLaundry");
                int numKitchens = property.getInt("numKitchens");
                return new Condo(name, address, ID, (Owner) loginManager.getUser(ownerID), sqFt, price,
                        numBedrooms, numBathrooms, numLaundry, numKitchens, bids);
            }
            if (Objects.equals(property.get("property_type").toString(), "Office")) {
                int numOfficeRooms = property.getInt("numOfficeRooms");
                int numReceptions = property.getInt("numReceptions");
                return new Office(name, address, ID, (Owner) loginManager.getUser(ownerID), sqFt, price,
                        numOfficeRooms, numReceptions, bids);
            }
            if (Objects.equals(property.get("property_type").toString(), "Restaurant")) {
                String kitchenSpecifications = property.getString("kitchenSpecifications");
                return new Restaurant(name, address, ID, (Owner) loginManager.getUser(ownerID), sqFt, price,
                        kitchenSpecifications, bids);
            }
            else {
                throw new UndefinedPropertyType(property.get("property_type") + " is not implemented as a property type yet.");
            }
        } catch (IOException | UndefinedUserType e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Helper method to convert a json object into a hashmap.
     *
     * @return HashMap of the json object. (String, Float)
     * @param j: json object to convert.
     */
    public HashMap<String, Float> parseBids(JSONObject j) {
        HashMap<String, Float> bids = new HashMap<>();
        for (String s: j.keySet()) {
            bids.put(s, j.getFloat(s));
        }
        return bids;
    }



    /**
     * Gets the review object with the associated id saved in the database.
     * Reads the database and retrieves the entry with a key equal to the id and then
     * reconstructs the review object from the information.
     *
     * @return review object of the given id.
     * @param ID: id of property to get.
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
     * @see PropertyGateway
     * converts the given property object into a json format and then reads the json from the file
     * adding the new property json before saving it back to the file.
     */
    @Override
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
                    new FileOutputStream(this.properties_filepath)))) {
                writer.write(a.toString());
            }
        } catch(Exception e){
            throw new Exception("Save failed.");
        }
    }

    /**
     * @see PropertyGateway
     * reads the json from the property file and for each entry reconstructs the property
     * object and returns it as a list.
     */
    @Override
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

    /**
     * @see PropertyGateway
     * reads the json from the property file and removes the entry associated with the given id, then
     * saves the json back to the file.
     */
    public void removePropertyById(String id) {
        try {
            Path filePath = Path.of(this.properties_filepath);
            String content = Files.readString(filePath);
            JSONObject a = new JSONObject(content);
            a.remove(id);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.properties_filepath)))) {
                writer.write(a.toString());
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
