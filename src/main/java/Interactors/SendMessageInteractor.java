package Interactors;
import Exceptions.MessageNotAppropriate;
import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Managers.MessageManager;

import java.io.IOException;

public class SendMessageInteractor {
    String User1_ID;
    String User2_ID;
    String message;

    public SendMessageInteractor(String User1_ID, String User2_ID, String message) {
        this.User1_ID = User1_ID;
        this.User2_ID = User2_ID;
        this.message = message;
    }

    public void sendMessage() throws MessengerNotFound, UndefinedUserType, IOException, MessageNotAppropriate {
        MessageManager.addMessage(User1_ID, User2_ID, message);
    }
}
