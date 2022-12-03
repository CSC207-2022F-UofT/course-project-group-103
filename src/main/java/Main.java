import Managers.LoginManager;
import Users.Owner;
import Users.Realtor;
import Users.User;
import org.json.JSONObject;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("niggerrrrrrrrrrrrrrrr");
        LoginManager lm = new LoginManager();
//        lm.saveToRealtorListing(new Realtor("123", "lol", "lmao1234",
//                "lol@lol.com", "a", "z"));
//        lm.saveToRealtorListing(new Realtor("124", "aasdfsadf", "lmao1235",
//                "sdfgdfsg@lol.com", "b", "y"));
        Realtor test = lm.getRealtor(2);
        System.out.println(test.getName());

    }
}
