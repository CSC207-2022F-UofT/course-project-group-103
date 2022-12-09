package Interactors;

import interactors.SingleListingModel;
import managers.LoginManager;
import managers.PropertyManager;
import org.junit.jupiter.api.Test;
import presenters.ListingScreenPresenter;
import screens.GUI;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RefreshListingInteractorTest {

    final String properties_path = "src/test/Databases/PropertyListing.json";
    final String users_path = "src/test/Databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        GUI view = new GUI();
        // use case is created in the constructor of presenter and then called
        ListingScreenPresenter presenter = new ListingScreenPresenter(view, propertyManager, loginManager) {
            @Override
            public void onUpdateFilterSuccess(ArrayList<SingleListingModel> listings) {
                assertEquals(listings.get(0).getID(), "1");
            }

            @Override
            public void onUpdateFilterFailure(String message) {
                assertEquals(message, "Failed to refresh listings.");
            }
        };
        presenter.onListingUpdate("0-100000", "0-1000000", false, false, true, false);
        presenter.onListingUpdate("0-500000", "0-1000000", true, false, true, false);
        presenter.onListingUpdate("0-1000000", "0-1000000", true, true, false, false);
    }
}