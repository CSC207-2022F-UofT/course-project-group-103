package interactors.output_boundary;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;

public interface MessengerOutput {
    void onSelection(String sender_ID, String receiver_ID) throws MessengerNotFound, UndefinedUserType, IOException;
}