package Interactors;

import Properties.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

// Use case layer
public interface PropertyListingGateway {
    /**
     * Saves a property object to the database.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    public void save(Property p);


    /**
     *
     * @param p: Property object to add to PropertyListing.json.
     * @throws IOException if the save was unsuccessful
     */
    public static void addProperty (Property p) throws IOException {
        String JSONString = Files.readString(Paths.get("src/main/Databases/PropertyListing.json"));
        JSONObject property = new JSONObject(JSONString);
        JSONObject property_info = new JSONObject();

        property_info.put("property_type", p.getClass().getSimpleName());
        property_info.put("name", p.getName());
        property_info.put("owner", p.getOwner().getID());
        property_info.put("sqFt", p.getSqFt());
        property_info.put("price", p.getPrice());

        if (p instanceof House) {
            property_info.put("numBedrooms", ((House)p).getNumBedrooms());
            property_info.put("numBathrooms", ((House)p).getNumBathrooms());
            property_info.put("numLaundry", ((House)p).getNumLaundry());
            property_info.put("numKitchens", ((House)p).getNumKitchen());
        } else if (p instanceof Condo) {
            property_info.put("numBedrooms", ((Condo)p).getNumBedrooms());
            property_info.put("numBathrooms", ((Condo)p).getNumBathrooms());
            property_info.put("numLaundry", ((Condo)p).getNumLaundry());
            property_info.put("numKitchens", ((Condo)p).getNumKitchen());
        } else if (p instanceof Restaurant) {
            property_info.put("kitchen_specifications", ((Restaurant) p).getKitchenSpecifications());
        } else if (p instanceof Office) {
            property_info.put("numOfficeRooms", ((Office)p).getNumOfficeRooms());
            property_info.put("numReceptions", ((Office)p).getNumReceptions());
        }

        property.put(p.getID(), property_info);

        try (FileWriter file = new FileWriter("src/main/Databases/PropertyListing.json")) {
            file.write(property.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getNumProperties() throws IOException {
        try {
            File file = new File("src/main/Databases/PropertyListing.json");
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject property_listing = new JSONObject(content);
            return property_listing.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static boolean nameExists(String name) throws IOException {
        String location = "src/main/Databases/PropertyListing.json";
        File file = new File(location);
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        JSONObject property_listing = new JSONObject(content);

        for (int i = 0; i < property_listing.length(); i++) {
            if (Objects.equals(property_listing.getJSONObject(Integer.toString(i)).getString("name"), name)) {
                return true;
            }
        }

        return false;

    }

}
