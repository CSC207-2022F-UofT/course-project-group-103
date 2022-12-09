import entities.User;
import managers.LoginManager;
import org.junit.jupiter.api.Test;
import presenters.SignUpScreenPresenter;

import static org.junit.jupiter.api.Assertions.*;

class SignUpInteractorTest {

    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/databases/ReviewList.json";

    @Test
    void create() {
        LoginManager loginManager = new LoginManager(users_path, reviews_path) {
            @Override
            public void saveUser(User u) {}
        };

        // use case is created in the constructor of presenter and then called
        presenter_dependancy p = new presenter_dependancy();
        SignUpScreenPresenter presenter = new SignUpScreenPresenter(p, loginManager) {
            @Override
            public void onSignUpSuccess(String id) {
                assertEquals("0", id);
            }

            @Override
            public void onSignUpFailure(String message) {
                fail(message);
            }
        };
        presenter.onSignUp("Test User", "test", "test", "test");
    }
}