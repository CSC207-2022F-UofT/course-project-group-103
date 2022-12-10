import managers.PropertyManager;
import managers.ReviewManager;
import org.junit.jupiter.api.Test;
import presenters.PropertyScreenPresenter;
import static org.junit.jupiter.api.Assertions.*;

class SendBidInteractorTest {

    final String properties_path = "src/test/databases/PropertyListing.json";
    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";
    final String inappropriate_words_path = "src/test/Databases/InappropriateWordsList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        ReviewManager reviewManager = new ReviewManager(reviews_path, inappropriate_words_path);

        // use case is created in the constructor of presenter and then called
        presenter_dependancy p = new presenter_dependancy();
        PropertyScreenPresenter presenter = new PropertyScreenPresenter(p, propertyManager, reviewManager) {
            @Override
            public void onSendBidSuccess() {
                try {
                    assertEquals(500000, propertyManager.getProperty("0").getBids().get("1"));
                } catch(Exception e) {fail("failed to get bid");}
            }

            @Override
            public void onSendBidFailure(String message) {
                fail(message);
            }
        };
        presenter.onSendBid("0", "500000");
    }
}