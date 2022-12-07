package interactors.containers;

import entities.User;

public class ActiveUser {

    /**
     * User class of the account currently using the application.
     */
    private User activeUser;

    /**
     * Changes the user class of the account using the application.
     *
     * @param u: user class of the new user using the application.
     */
    public void setActiveUser(User u) {
        this.activeUser = u;
    }

    /**
     * Returns the current user.
     * @return the user class of the account using the application.
     */
    public User getActiveUser() {
        return this.activeUser;
    }

}
