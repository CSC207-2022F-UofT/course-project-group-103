package interactors.containers;

import entities.User;

public class ActiveUser {
    private User activeUser;

    public void setActiveUser(User u) {
        this.activeUser = u;
    }

    public User getActiveUser() {
        return this.activeUser;
    }

}
