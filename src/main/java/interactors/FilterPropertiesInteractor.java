//package Interactors;
//
//import Exceptions.UndefinedPropertyType;
//import Managers.PropertyManager;
//import Properties.Property;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Set;
//public class FilterPropertiesInteractor {
//    /// use getSold  & getPrice & property type in one method called getProperties
//    public static ArrayList<ArrayList<String>> getProperties(float min, float max, String category) throws IOException, UndefinedPropertyType {
//        String location = new String("/Users/rakan/IdeaProjects/103 Project/src/main/Databases/PropertyListing.json");
//        File file = new File(location);
//        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
//        JSONObject obj = new JSONObject(content);
//     ///   float price = obj.getJSONObject(id).getFloat("price");
//        Set<String> ID = obj.keySet();
//        ArrayList<ArrayList<String>> properties = new ArrayList<>();
//        for(String id: ID) {
//            if(PropertyManager.getPrice(id) <= max & PropertyManager.getPrice(id) >= min) {
//                    if(PropertyManager.getPropertyType(id).equals(category) && !(PropertyManager.getSold(id))) {
//                        properties.add(PropertyManager.getProperty(id).info());
//
//                    }
//                }
//            }
//        return properties;
//        }
//    }
//
