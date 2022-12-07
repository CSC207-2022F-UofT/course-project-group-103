import Exceptions.UndefinedPropertyType;
import Interactors.AccessSinglePropertyInteractor;
import Interactors.PropertyListingGateway;
import Interactors.PropertyPageInteractor;
import Managers.PropertyManager;
import Properties.Property;
import Screens.PropertyPageController;
import Screens.PropertyPageScreen;
import Screens.SinglePropertyPageScreen;
import Screens.SinglePropertyPageScreenController;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws UndefinedPropertyType {
        AccessSinglePropertyInteractor interactor = new AccessSinglePropertyInteractor("0");
        SinglePropertyPageScreenController controller = new SinglePropertyPageScreenController(interactor);
        new SinglePropertyPageScreen(controller);
    }
}
