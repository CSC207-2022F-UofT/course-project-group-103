import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import screens.*;

import java.io.IOException;

public class Main {
    /**
     * Filepaths for the database can be changed in the GUI class,
     * run main to start.
     */
    public static void main(String[] args) throws IOException, MessengerNotFound, UndefinedUserType {
        GUI application = new GUI();
        application.pack();
        application.setVisible(true);
    }
}
