package interactors.input_boundary;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;
import java.util.ArrayList;

public interface MessengerInput {

    ArrayList<String> getChat(String sender_ID, String receiver_ID) throws UndefinedUserType, IOException, MessengerNotFound;
    String[] getNames(String sender_ID) throws IOException, UndefinedUserType, MessengerNotFound;

    String getUserID(String username);

}
