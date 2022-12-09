import entities.Property;
import managers.LoginManager;
import managers.PropertyManager;
import org.junit.jupiter.api.Test;
import presenters.CreateListingPresenter;

import static org.junit.jupiter.api.Assertions.*;

class CreateListingInteractorTest {

    final String properties_path = "src/test/databases/PropertyListing.json";
    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/databases/ReviewList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path) {
            @Override
            public void save(Property p) {}
        };
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        // use case is created in the constructor of presenter and then called
        presenter_dependancy p = new presenter_dependancy();
        CreateListingPresenter presenter = new CreateListingPresenter(p, propertyManager, loginManager) {
            @Override
            public void onCreateListingSuccess() {
                try {
                    assertEquals(propertyManager.getProperty("2").getName(), "Test Restaurant");
                } catch (Exception e) {fail("Failed to access the property after creating a restaurant");}
            }

            @Override
            public void onCreateListingFailure(String message) {
                fail("failed to create listing");
            }
        };
        presenter.onCreateRestaurant("Test Restaurant", "Test", "1","1","Test");
    }
}