import entities.Property;
import interactors.SendBidInteractor;
import interactors.output_boundary.SendBidOutput;
import managers.PropertyManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SendBidInteractorTest {

    final String properties_path = "src/test/databases/PropertyListing.json";
    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path) {
            @Override
            public void save(Property p) {
                assertEquals(100000, p.getBids().get("1"));
            }
        };

        class Output implements SendBidOutput {
            @Override
            public void onSendBidSuccess() {}

            @Override
            public void onSendBidFailure(String message) {
                fail("failed to send bid");
            }
        }
        Output output = new Output();
        SendBidInteractor test = new SendBidInteractor(propertyManager, output);
        test.sendBid("1", "100000", "1");
    }
}