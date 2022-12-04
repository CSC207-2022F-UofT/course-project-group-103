package controllers;

import interactors.AccountInteractor;
import interactors.SingleListingInteractor;

import java.util.ArrayList;

public class AccountController {

    AccountInteractor accountInteractor;
    Presenter presenter;

    public AccountController(AccountInteractor i, Presenter p) {
        this.accountInteractor = i;
        this.presenter = p;
    }

    public ArrayList<SingleListingController> createUserProperties() {
        ArrayList<SingleListingController> controllers = new ArrayList<>();
        for (SingleListingInteractor i: this.accountInteractor.createUserProperties()) {
            controllers.add(new SingleListingController(i, this.presenter));
        }
        return controllers;
    }

    public ArrayList<String> getInfo() {
        return this.accountInteractor.getInfo();
    }

    public boolean isOwnerType() {
        return this.accountInteractor.isOwnerType();
    }

    public void back() {
        this.presenter.displayPrevious();
    }
}
