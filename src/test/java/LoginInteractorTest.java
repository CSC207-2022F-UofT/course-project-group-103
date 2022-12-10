import interactors.LoginInteractor;
import interactors.output_boundary.LoginOuput;
import managers.LoginManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    final String users_path = "src/test/Databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";

    @Test
    void create() {
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        class Output implements LoginOuput {
            @Override
            public void onLoginSuccess(String id) {
                assertEquals("4", id);
            }

            @Override
            public void onLoginFailure(String message) {

            }
        }
        Output output = new Output();
        LoginInteractor test = new LoginInteractor(loginManager, output);
        test.login("Omar", "Omar123");
    }
}