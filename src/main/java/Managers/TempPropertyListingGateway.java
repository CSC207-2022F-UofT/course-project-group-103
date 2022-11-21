package Managers;

import Properties.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempPropertyListingGateway {
    /**
     * Adds the given JSON object associated with the given ID to PropertyListing.json.
     *
     * Converts the contents of PropertyListing.json into a JSON object and adds the new JSON object overwriting
     * others with the same ID, then the new PropertyListing JSON Object is written to the file. This is a given as a
     * temporary implementation just to get bidding to work, it is probably not a good way of writing to file as if two
     * users did it on the same property it would overwrite the user who called it first.
     *
     * @param p: Property object to add to PropertyListing.json.
     */
    public static void writeToFile(Property p) {
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

