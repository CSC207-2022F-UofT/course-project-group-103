package controllers;

import interactors.ActiveAccountInteractor;
import interactors.SingleListingInteractor;

import java.util.ArrayList;

public class ActiveAccountController {

    ActiveAccountInteractor activeAccountInteractor;
    Presenter presenter;

    public ActiveAccountController(ActiveAccountInteractor i, Presenter p) {
        this.activeAccountInteractor = i;
        this.presenter = p;
    }

    public ArrayList<SingleListingController> createUserProperties() {
        ArrayList<SingleListingController> controllers = new ArrayList<>();
        for (SingleListingInteractor i: this.activeAccountInteractor.createUserProperties()) {
            controllers.add(new SingleListingController(i, this.presenter));
        }
        return controllers;
    }

    public ArrayList<String> getInfo() {
        return this.activeAccountInteractor.getInfo();
    }

    public boolean isOwnerType() {
        return this.activeAccountInteractor.isOwnerType();
    }

    public void signOut() {
        this.activeAccountInteractor.signOut();
        this.presenter.displayLogin();
    }

    public void back() {
        this.presenter.displayPrevious();
    }
}
