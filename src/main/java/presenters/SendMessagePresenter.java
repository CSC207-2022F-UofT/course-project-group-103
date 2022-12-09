package presenters;

import interactors.SendMessageInteractor;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.MessengerGateway;
import interactors.input_boundary.SendMessageInput;
import interactors.output_boundary.SendMessageOutput;

import java.io.IOException;

public class SendMessagePresenter implements SendMessageOutput {
    ViewInterface viewInterface;
    SendMessageInput sendMessageInput;

    public SendMessagePresenter(ViewInterface view, MessengerGateway gateway, LoginGateway loginGateway) {
        this.viewInterface = view;
        this.sendMessageInput = new SendMessageInteractor(gateway, loginGateway, this);
    }

    public void onPress(String sender_ID, String receiver_ID, String message) throws MessengerNotFound, UndefinedUserType, IOException {
        this.sendMessageInput.sendMessage(sender_ID, receiver_ID, message);
        this.viewInterface.displayChat(receiver_ID);
    }
}
