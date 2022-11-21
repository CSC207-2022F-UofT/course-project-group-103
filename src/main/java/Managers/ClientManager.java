package Managers;
import java.util.ArrayList;
import Users.*;

public class ClientManager {
    private ArrayList<User> clientList = new ArrayList<>();

    public ClientManager(ArrayList<User> clientList){
        this.clientList = clientList;
    }

    public ArrayList<User> getClients() {
        return clientList;
    }

    public void addClient(User client) {
        clientList.add(client);
    }

    public void removeClient(User client) {
        clientList.remove(client);
    }
}
