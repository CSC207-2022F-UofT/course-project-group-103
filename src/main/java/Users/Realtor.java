package Users;

import Managers.ClientManager;

public class Realtor extends User {
    private String name;
    private int com;
    private ClientManager clientManager;

    public Realtor(String name) {
        super(name);
    }

    public void setCommission(int com) {
        this.com = com;
    }

    public int getCommission() {
        return com;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }


}
