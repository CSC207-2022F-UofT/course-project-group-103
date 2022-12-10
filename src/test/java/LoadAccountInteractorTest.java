import interactors.AccountModel;
import interactors.LoadAccountInteractor;
import interactors.ReviewModel;
import interactors.SingleListingModel;
import interactors.output_boundary.LoadAccountOutput;
import managers.PropertyManager;
import managers.ReviewManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoadAccountInteractorTest {

    final String properties_path = "src/test/Databases/PropertyListing.json";
    final String users_path = "src/test/Databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";
    final String inappropriate_words_path = "src/test/Databases/InappropriateWordsList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        ReviewManager reviewManager = new ReviewManager(reviews_path, inappropriate_words_path);

        class Output implements LoadAccountOutput {
            @Override
            public void onLoadAccountSuccess(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                                             AccountModel account) {
                assertEquals(listings.get(0).getID(), "0");
                assertEquals(listings.get(1).getID(), "1");
                assertEquals(reviews.get(0).getWriterName(), "Sean");
                assertEquals(reviews.get(1).getWriterName(), "Sean");
                assertEquals(account.getName(), "Omar");
                assertEquals(account.getContact(), "omar@gmail.com");
            }

            @Override
            public void onLoadAccountFailure(String message) {
                fail("failed to load account");
            }
        }
        Output output = new Output();
        LoadAccountInteractor test = new LoadAccountInteractor(propertyManager, reviewManager, output);
        test.loadAccount("4");
    }
}