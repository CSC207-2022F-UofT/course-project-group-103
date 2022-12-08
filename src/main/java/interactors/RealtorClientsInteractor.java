package interactors;
import entities.User;
import interactors.UserGateway;

import java.io.IOException;
import java.util.ArrayList;

public class RealtorClientsInteractor {
    public ArrayList<User> getClients(String ID) throws IOException {
        UserGateway userGateway = new UserGateway();
        return userGateway.getRealtorClients(ID);
    }
}
