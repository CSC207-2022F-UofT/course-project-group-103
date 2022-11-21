package Managers;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PropertyManager {
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
