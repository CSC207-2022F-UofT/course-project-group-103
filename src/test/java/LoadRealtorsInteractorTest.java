import interactors.SingleRealtorModel;
import managers.LoginManager;
import managers.PropertyManager;
import managers.ReviewManager;
import org.junit.jupiter.api.Test;
import presenters.HomeScreenPresenter;
import screens.GUI;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoadRealtorsInteractorTest {

    final String properties_path = "src/test/Databases/PropertyListing.json";
    final String users_path = "src/test/Databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";
    final String inappropriate_words_path = "src/test/Databases/InappropriateWordsList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        LoginManager loginManager = new LoginManager(users_path, reviews_path);
        ReviewManager reviewManager = new ReviewManager(reviews_path, inappropriate_words_path);

        GUI view = new GUI();
        // use case is created in the constructor of presenter and then called
        HomeScreenPresenter presenter = new HomeScreenPresenter(view, propertyManager, reviewManager, loginManager) {
            @Override
            public void onLoadRealtorsSuccess(ArrayList<SingleRealtorModel> realtors) {
                assertEquals(realtors.get(0).getID(), "2");
            }

            @Override
            public void onLoadListingFailure(String message) {
                assertEquals(message, "Failed to load realtors.");
            }
        };
        presenter.onLoadRealtors();
    }
}