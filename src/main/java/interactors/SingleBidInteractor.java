package interactors;

import entities.User;
import interactors.containers.AccountToDisplay;

import java.util.ArrayList;

public class SingleBidInteractor {

    User user;
    float bid;
    AccountToDisplay accountToDisplay;

    public SingleBidInteractor(User u, float bid, AccountToDisplay a) {
        this.user = u;
        this.bid = bid;
        this.accountToDisplay = a;
    }

    public ArrayList<String> bidInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add("Username: " + this.user.getName());
        info.add("Offer Amount: " + this.bid);
        return info;
    }

    public void updateAccountDisplay() {
        this.accountToDisplay.setAccountDisplay(this.user);
    }

}
