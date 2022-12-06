package Screens;

import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Interactors.OpenMessengerInteractor;

import java.io.IOException;

public class OpenMessengerController {
    OpenMessengerInteractor openMessengerInteractor;

    public OpenMessengerController(OpenMessengerInteractor interactor) {
        this.openMessengerInteractor = interactor;
    }

    public void displayChat() throws MessengerNotFound, UndefinedUserType, IOException {
        this.openMessengerInteractor.displayChat();
    }
}
