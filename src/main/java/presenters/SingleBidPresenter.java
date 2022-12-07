package presenters;

import interactors.SingleBidInteractor;

import java.util.ArrayList;

public class SingleBidPresenter {

    SingleBidInteractor singleBidInteractor;
    ViewInterface viewInterface;

    public SingleBidPresenter(SingleBidInteractor i, ViewInterface p) {
        this.singleBidInteractor = i;
        this.viewInterface = p;
    }

    /**
     * Returns list of basic info about a bid.
     *
     * Calls the SingleBidInteractor method bidInfo().
     */
    public ArrayList<String> onBidInfo() {
        return this.singleBidInteractor.bidInfo();
    }

    /**
     * Displays the account of the user who placed this bid.
     *
     * Calls the SingleBidInteractor method updateAccountDisplay() to update the accounts page current
     * account and then displays the account page.
     */
    public void onAccount() {
        this.singleBidInteractor.updateAccountDisplay();
        this.viewInterface.displayAccount();
    }

}
