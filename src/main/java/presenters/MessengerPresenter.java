package presenters;

import interactors.MessengerInteractor;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.MessengerGateway;
import interactors.input_boundary.MessengerInput;
import interactors.output_boundary.MessengerOutput;

import java.io.IOException;
import java.util.ArrayList;

public class MessengerPresenter implements MessengerOutput {
    public ViewInterface viewInterface;
    MessengerInput messengerInput;

    public MessengerPresenter(ViewInterface view, MessengerGateway gatewayMessenger, LoginGateway gatewayLogin) {
        this.viewInterface = view;
        this.messengerInput = new MessengerInteractor(gatewayMessenger, gatewayLogin, this);
    }

    public void onSelection(String sender_ID, String receiver_ID) throws MessengerNotFound, UndefinedUserType, IOException {
        this.messengerInput.getChat(sender_ID, receiver_ID);
    }

    public String[] getNames(String sender_ID) throws MessengerNotFound, UndefinedUserType, IOException {
        return this.messengerInput.getNames(sender_ID);
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    public String getUserID(String username) {
        return this.messengerInput.getUserID(username);
    }

    public ArrayList<String> getChat(String senderID, String receiverID) throws MessengerNotFound, UndefinedUserType, IOException {
        return this.messengerInput.getChat(senderID, receiverID);
    }
}
