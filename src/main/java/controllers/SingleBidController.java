package controllers;

import interactors.SingleBidInteractor;

import java.util.ArrayList;

public class SingleBidController {

    SingleBidInteractor singleBidInteractor;
    Presenter presenter;

    public SingleBidController(SingleBidInteractor i, Presenter p) {
        this.singleBidInteractor = i;
        this.presenter = p;
    }

    /**
     * Returns list of basic info about a bid.
     *
     * Calls the SingleBidInteractor method bidInfo().
     */
    public ArrayList<String> getBidInfo() {
        return this.singleBidInteractor.bidInfo();
    }

    public void account() {
        this.singleBidInteractor.updateAccountDisplay();
        this.presenter.displayAccount();
    }

}
