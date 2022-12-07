package interactors;

import entities.User;
import interactors.containers.AccountToDisplay;

import java.util.ArrayList;

public class SingleBidInteractor {

    /**
     * User associated with the bid.
     */
    User user;
    /**
     * Float value of the bid.
     */
    float bid;
    /**
     * Current account being accessed.
     */
    AccountToDisplay accountToDisplay;

    /**
     * Constructor for the single bid interactor, assigns object instances to its attributes.
     *
     * @param u: user instance associated with this bid interactors bid.
     * @param bid: float value associated with this bid interactors bid.
     * @param a: AccountToDisplay class for this application instance's account being accessed.
     */
    public SingleBidInteractor(User u, float bid, AccountToDisplay a) {
        this.user = u;
        this.bid = bid;
        this.accountToDisplay = a;
    }

    /**
     * Returns an Array List of all relevant attributes of the bid.
     * @return Array List of formatted string representations of the bid information.
     */
    public ArrayList<String> bidInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Username: " + this.user.getName());
        info.add("Offer Amount: " + this.bid);
        return info;
    }

    /**
     * Changes the currently accessed account to the user associated with this bid.
     */
    public void updateAccountDisplay() {
        this.accountToDisplay.setAccountDisplay(this.user);
    }

}
