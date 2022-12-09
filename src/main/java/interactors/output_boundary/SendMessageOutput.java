package interactors.output_boundary;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;

public interface SendMessageOutput {
    void onPress(String sender_ID, String receiver_ID, String message) throws MessengerNotFound, UndefinedUserType, IOException;
}
