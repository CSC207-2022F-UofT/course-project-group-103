import interactors.RefreshListingInteractor;
import interactors.SingleListingModel;
import interactors.output_boundary.RefreshListingOutput;
import managers.PropertyManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class RefreshListingInteractorTest {

    final String properties_path = "src/test/Databases/PropertyListing.json";
    final String users_path = "src/test/Databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";

    @Test
    void create() {
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);

        class Output implements RefreshListingOutput {
            @Override
            public void onUpdateFilterSuccess(ArrayList<SingleListingModel> listings) {
                assertEquals("1", listings.get(0).getID());
            }

            @Override
            public void onUpdateFilterFailure(String message) {
                fail("failed to update filters");
            }
        }
        Output output = new Output();
        RefreshListingInteractor test = new RefreshListingInteractor(propertyManager, output);
        test.updateFilter("0-500000", "0-5000", false, false, true, false);
    }
}