import managers.LoginManager;
import org.junit.jupiter.api.Test;
import presenters.LoginScreenPresenter;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    final String users_path = "src/test/Databases/UserListing.json";
    final String reviews_path = "src/test/Databases/ReviewList.json";

    @Test
    void create() {
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        presenter_dependancy p = new presenter_dependancy();
        // use case is created in the constructor of presenter and then called
        LoginScreenPresenter presenter = new LoginScreenPresenter(p, loginManager) {
            @Override
            public void onLoginSuccess(String id) {
                assertEquals("4", id);
            }

            @Override
            public void onLoginFailure(String message) {
                assertEquals(message, "Failed to login.");
            }
        };
        presenter.onLogin("Omar", "Omar123");
    }
}