import entities.Property;
import interactors.CreateListingInteractor;
import interactors.output_boundary.CreateListingOutput;
import managers.LoginManager;
import managers.PropertyManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreateListingInteractorTest {

    final String properties_path = "src/test/databases/PropertyListing.json";
    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/databases/ReviewList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path) {
            @Override
            public void save(Property p) {
                assertEquals("Test Restaurant", p.getName());
            }
        };
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        class Output implements CreateListingOutput {
            @Override
            public void onCreateListingSuccess() {}

            @Override
            public void onCreateListingFailure(String message) {
                fail(message);
            }
        }
        Output output = new Output();
        CreateListingInteractor test = new CreateListingInteractor(propertyManager, loginManager, output);
        test.createRestaurant("Test Restaurant", "Test Address", "1000", "1000", "Specs", "4");
    }
}
