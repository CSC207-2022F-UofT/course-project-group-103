package Interactors;

import Entities.Users.Realtor;
import java.io.IOException;
import java.util.ArrayList;

public class RealtorSearchInteractor {
    public ArrayList<Realtor> listRealtors() throws IOException {
        UserGateway userGateway = new UserGateway();
        return userGateway.getRealtors();
    }
}
