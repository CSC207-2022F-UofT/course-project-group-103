package presenters;

import interactors.ActiveAccountInteractor;
import interactors.SingleListingInteractor;
import interactors.SingleReviewInteractor;

import java.util.ArrayList;

public class ActiveAccountPresenter {

    ActiveAccountInteractor activeAccountInteractor;
    ViewInterface viewInterface;

    public ActiveAccountPresenter(ActiveAccountInteractor i, ViewInterface p) {
        this.activeAccountInteractor = i;
        this.viewInterface = p;
    }

    /**
     * Creates an ArrayList of controllers for the active accounts listed properties.
     *
     * Iterates over the list of the single listing interactors created by the active account interactor method
     * createUserProperties().
     */
    public ArrayList<SingleListingPresenter> onCreateUserProperties() {
        ArrayList<SingleListingPresenter> controllers = new ArrayList<>();
        for (SingleListingInteractor i: this.activeAccountInteractor.createUserProperties()) {
            controllers.add(new SingleListingPresenter(i, this.viewInterface));
        }
        return controllers;
    }

    /**
     * Creates an ArrayList of controllers for the active accounts listed reviews.
     *
     * Iterates over the list of the single listing interactors created by the active account interactor method
     * createUserReviews().
     */
    public ArrayList<SingleReviewPresenter> onCreateUserReviews() {
        ArrayList<SingleReviewPresenter> controllers = new ArrayList<>();
        for (SingleReviewInteractor i: this.activeAccountInteractor.createUserReviews()) {
            controllers.add(new SingleReviewPresenter(i, this.viewInterface));
        }
        return controllers;
    }

    /**
     * Returns an array list of string representing the basic info of the active account.
     *
     * Calls the active account interactor method getInfo() and returns the results.
     */
    public ArrayList<String> onGetInfo() {
        return this.activeAccountInteractor.getInfo();
    }

    /**
     * Returns true if the active account is of an owner type user.
     *
     * Calls the active account interactor method isOwnerType() and returns the result.
     */
    public boolean onOwnerType() {
        return this.activeAccountInteractor.isOwnerType();
    }

    /**
     * Signs the user out and displays the login page.
     *
     * Calls the active account interactor method signOut() and then calls the presenter method displayLogin()
     */
    public void onSignOut() {
        this.activeAccountInteractor.signOut();
        this.viewInterface.displayLogin();
    }

    /**
     * Goes back to previous page.
     *
     * Calls the presenter method displayPrevious() implemented in the GUI class.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Sends delete account request to the interactor and displays the login page if successful
     *
     * Calls the active account interactor method deleteAccount() and then calls the presenter method displayLogin()
     *
     * @param password: password entered by user for confirmation
     * @throws Exception: delete account failed
     */
    public void onDeleteAccount(String password) throws Exception {
        this.activeAccountInteractor.deleteAccount(password);
        this.viewInterface.displayLogin();
    }
}
