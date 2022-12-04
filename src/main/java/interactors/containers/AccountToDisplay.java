package interactors.containers;

import entities.User;

public class AccountToDisplay {

    private User account;

    public void setAccountDisplay(User u) {
        this.account = u;
    }

    public User getAccountDisplay() {
        return this.account;
    }

}
