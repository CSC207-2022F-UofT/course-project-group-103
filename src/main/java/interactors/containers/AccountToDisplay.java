package interactors.containers;

import entities.User;

public class AccountToDisplay {

    /**
     * User class of the account currently being accessed in the model.
     */
    private User account;

    /**
     * Changes the user class of the account that should access in the model.
     *
     * @param u: user class of the new account to access.
     */
    public void setAccountDisplay(User u) {
        this.account = u;
    }

    /**
     * Returns the account being accessed.
     * @return the user class of the account being accessed.
     */
    public User getAccountDisplay() {
        return this.account;
    }

}
