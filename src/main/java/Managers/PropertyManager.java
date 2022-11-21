package Managers;

import Interactors.PropertyListingGateway;
import Properties.Property;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class PropertyManager implements PropertyListingGateway {

    /**
     * Implements the save method of the PropertyListingGateway for dependency inversion. This is a temporary
     * implementation just so that bidding can work it is probably not a good way of doing this.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    public void save(Property p) {
        try {
            Path filePath = Path.of("PropertyListing.json");
            String content = Files.readString(filePath);
            JSONTokener a = new JSONTokener(content);
            JSONObject b = new JSONObject(a);
            JSONObject prop = new JSONObject(p);
            b.put(p.getID(), prop);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("PropertyListing.json"), "utf-8"))) {
                writer.write(b.toString());
            }
        } catch(Exception e) {}
    }
}
