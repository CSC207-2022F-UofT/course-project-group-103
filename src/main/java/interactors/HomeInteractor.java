package interactors;

import interactors.containers.AccountToDisplay;
import interactors.containers.ActiveUser;

public class HomeInteractor {
    AccountToDisplay accountToDisplay;
    ActiveUser activeUser;

    public HomeInteractor(AccountToDisplay a, ActiveUser u) {
        this.accountToDisplay = a;
        this.activeUser = u;
    }

    public void updateAccountDisplay() {
        this.accountToDisplay.setAccountDisplay(this.activeUser.getActiveUser());
    }
}
