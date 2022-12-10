import entities.User;
import interactors.SignUpInteractor;
import interactors.output_boundary.SignUpOutput;
import managers.LoginManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpInteractorTest {

    final String users_path = "src/test/databases/UserListing.json";
    final String reviews_path = "src/test/databases/ReviewList.json";

    @Test
    void create() {
        LoginManager loginManager = new LoginManager(users_path, reviews_path) {
            @Override
            public void saveUser(User u) {
                assertEquals("Test User", u.getName());
            }
        };

        class Output implements SignUpOutput {
            @Override
            public void onSignUpSuccess(String id) {
                assertEquals("0", id);
            }

            @Override
            public  void onSignUpFailure(String message) {
                fail("Failed to sign up");
            }
        }
        Output output = new Output();
        SignUpInteractor test = new SignUpInteractor(loginManager, output);
        test.signUp("Test User", "test@gmail.com", "Test123", "Test123");
    }
}