import interactors.AccessPropertyInteractor;
import interactors.PropertyModel;
import interactors.output_boundary.AccessPropertyOutput;
import managers.LoginManager;
import managers.PropertyManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessPropertyInteractorTest {

    final String properties_path = "src/test/databases/PropertyListing.json";
    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/databases/ReviewList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        class Output implements AccessPropertyOutput {
            @Override
            public void onAccessPropertySuccess(PropertyModel property) {
                assertEquals("0", property.getPropertyID());
                assertEquals("4", property.getOwnerID());
                assertEquals(1, property.getNumKitchens());
                assertEquals(4, property.getNumBath());
                assertEquals(3, property.getNumBed());
                assertEquals(1, property.getNumLaundry());
                assertEquals(100, property.getSqFt());
                assertEquals("Omar's House", property.getName());
                assertEquals("36 Bloor St. E", property.getAddress());
                assertEquals(500000, property.getPrice());
            }
            @Override
            public void onAccessPropertyFailure(String message) {
                fail("failed to load property");
            }
        }
        Output output = new Output();
        AccessPropertyInteractor test = new AccessPropertyInteractor(propertyManager, loginManager, output);
        test.accessProperty("0");
    }
}