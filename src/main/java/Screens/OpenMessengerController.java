package Screens;

import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Interactors.OpenMessengerInteractor;
import Managers.PropertyManager;
import Users.User;

import java.io.IOException;

public class OpenMessengerController {
    OpenMessengerInteractor openMessengerInteractor;

    public OpenMessengerController(OpenMessengerInteractor interactor) {
        this.openMessengerInteractor = interactor;
    }

    public void displayChat() throws MessengerNotFound, UndefinedUserType, IOException {
        this.openMessengerInteractor.displayChat();
    }

    public String getUsername(String receiver_ID) throws UndefinedUserType, IOException {
        User receiver = PropertyManager.getUser(receiver_ID);
        return  receiver.getName();
    }
}
