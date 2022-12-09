package interactors.input_boundary;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;

public interface SendMessageInput {
    void sendMessage(String sender_ID, String receiver_ID, String message) throws UndefinedUserType, MessengerNotFound, IOException;
}
