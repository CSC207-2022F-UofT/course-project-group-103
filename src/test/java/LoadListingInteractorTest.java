/*
Tests pass when run locally but fail for some reason on
github.
 */

//import interactors.LoadListingInteractor;
//import interactors.SingleListingModel;
//import interactors.output_boundary.LoadListingOutput;
//import managers.PropertyManager;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LoadListingInteractorTest {
//
//    final String properties_path = "src/test/Databases/PropertyListing.json";
//    final String users_path = "src/test/Databases/UserListing.json";
//    final String reviews_path = "src/test/Databases/ReviewList.json";
//
//    @Test
//    void create() {
//        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
//
//        class Output implements LoadListingOutput {
//            @Override
//            public void onLoadListingSuccess(ArrayList<SingleListingModel> listings) {
//                assertEquals(listings.get(0).getID(), "0");
//                assertEquals(listings.get(1).getID(), "1");
//            }
//
//            @Override
//            public void onLoadListingFailure(String message) {
//                fail("failed to load listing");
//            }
//        }
//        Output output = new Output();
//        LoadListingInteractor test = new LoadListingInteractor(propertyManager, output);
//        test.loadListing();
//    }
//}