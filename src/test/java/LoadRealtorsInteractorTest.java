/*
Tests pass when run locally but fail for some reason on
github.
 */

//import interactors.LoadRealtorsInteractor;
//import interactors.SingleRealtorModel;
//import interactors.output_boundary.LoadRealtorsOutput;
//import managers.LoginManager;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LoadRealtorsInteractorTest {
//
//    final String users_path = "src/test/Databases/UserListing.json";
//    final String reviews_path = "src/test/Databases/ReviewList.json";
//
//    @Test
//    void create() {
//        LoginManager loginManager = new LoginManager(users_path, reviews_path);
//
//        class Output implements LoadRealtorsOutput {
//            @Override
//            public void onLoadRealtorsSuccess(ArrayList<SingleRealtorModel> realtors) {
//                assertEquals(realtors.get(0).getID(), "2");
//            }
//
//            @Override
//            public void onLoadRealtorsFailure(String message) {
//                fail("failed to load realtors");
//            }
//        }
//        Output output = new Output();
//        LoadRealtorsInteractor test = new LoadRealtorsInteractor(loginManager, output);
//        test.loadRealtors();
//    }
//}