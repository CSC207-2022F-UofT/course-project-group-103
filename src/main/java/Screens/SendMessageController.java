package Screens;

import Exceptions.MessageNotAppropriate;
import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Interactors.SendMessageInteractor;

import java.io.IOException;

public class SendMessageController {
    SendMessageInteractor sendMessageInteractor;

    public SendMessageController(SendMessageInteractor interactor) {
        this.sendMessageInteractor = interactor;
    }

    public void sendMessage() throws MessengerNotFound, UndefinedUserType, IOException, MessageNotAppropriate {
        this.sendMessageInteractor.sendMessage();
    }
}
