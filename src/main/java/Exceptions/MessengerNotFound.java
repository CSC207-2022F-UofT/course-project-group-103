package Exceptions;
import Messenger.Messenger;
import Users.User;

public class MessengerNotFound extends Exception{
    public MessengerNotFound(String message) {
        super(message);
    }
}
