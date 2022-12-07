
/*
package presenters;


import interactors.AccountInteractor;
import interactors.SingleListingInteractor;
import interactors.SingleReviewInteractor;

import java.util.ArrayList;

public class AccountScreenPresenter {

    AccountInteractor accountInteractor;
    ViewInterface viewInterface;

    public AccountScreenPresenter(AccountInteractor i, ViewInterface p) {
        this.accountInteractor = i;
        this.viewInterface = p;
    }

    /**
     * Creates an ArrayList of controllers for the accounts listed properties.
     *
     * Iterates over the list of the single listing interactors created by the account interactor method
     * createUserProperties().
     */


/*
    public ArrayList<SingleListingPresenter> onCreateUserProperties() {
        ArrayList<SingleListingPresenter> controllers = new ArrayList<>();
        for (SingleListingInteractor i: this.accountInteractor.createUserProperties()) {
            controllers.add(new SingleListingPresenter(i, this.viewInterface));
        }
        return controllers;
    }

    /**
     * Creates an ArrayList of controllers for the accounts listed reviews.
     *
     * Iterates over the list of the single listing interactors created by the account interactor method
     * createUserReviews().
     */
/*
    public ArrayList<SingleReviewPresenter> onCreateUserReviews() {
        ArrayList<SingleReviewPresenter> controllers = new ArrayList<>();
        for (SingleReviewInteractor i: this.accountInteractor.createUserReviews()) {
            controllers.add(new SingleReviewPresenter(i, this.viewInterface));
        }
        return controllers;
    }


    /**
     * Returns an array list of string representing the basic info of the account.
     *
     * Calls the account interactor method getInfo() and returns the results.
     */
/*
    public ArrayList<String> onGetInfo() {
        return this.accountInteractor.getInfo();
    }

    /**
     * Returns true if the account being displayed is of an owner type user.
     *
     * Calls the account interactor method isOwnerType() and returns the result.
     */
/*
    public boolean onOwnerType() {
        return this.accountInteractor.isOwnerType();
    }

    /**
     * Goes back to previous page.
     *
     * Calls the presenter method displayPrevious() implemented in the GUI class.
     */
/*
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Displays the create review page.
     *
     * Calls the presenter method displayCreateReview() implemented in the GUI class.
     */
/*
    public void onCreateReview() {this.viewInterface.displayCreateReview();}
}
*/