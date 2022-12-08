package interactors;
import interactors.exceptions.MessageNotAppropriate;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.MessengerGateway;
import interactors.input_boundary.SendMessageInput;
import interactors.output_boundary.SendMessageOutput;
import managers.MessageManager;

import java.io.IOException;

public class SendMessageInteractor implements SendMessageInput {
    MessengerGateway messengerGateway;
    LoginGateway loginGateway;
    SendMessageOutput sendMessageOutput;

    public SendMessageInteractor(MessengerGateway gatewayMessenger, LoginGateway gatewayLogin,
                                 SendMessageOutput output) {
        this.messengerGateway = gatewayMessenger;
        this.loginGateway = gatewayLogin;
        this.sendMessageOutput = output;
    }

    public void sendMessage(String User1_ID, String User2_ID, String message)
            throws MessengerNotFound, UndefinedUserType, IOException {
        this.messengerGateway.addMessage(User1_ID, User2_ID, message);
    }
}
