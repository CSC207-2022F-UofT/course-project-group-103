package presenters;

import interactors.AccountModel;
import interactors.PropertyModel;
import interactors.ReviewModel;
import interactors.SingleListingModel;

import java.util.ArrayList;

// controller layer
public interface ViewInterface {
    /**
     * Displays the login page.
     */
    void displayLogin();
    /**
     * Displays a failure message.
     */
    void displayFailure(String message);
    /**
     * Displays a success message.
     */
    void displaySuccess(String message);
    /**
     * Displays the home page.
     */
    void displayHome();
    /**
     * Displays the sign-up page.
     */
    void displaySignUp();
    /**
     * Refreshes the listing page.
     */
    void refreshListing(ArrayList<SingleListingModel> info);
    /**
     * Displays the property page.
     */
    void displayProperty(PropertyModel property);
    /**
     * Displays the previous page.
     */
    void displayPrevious();
    /**
     * Displays the listings page.
     */
    void displayListing();
    /**
     * Displays the create-listing page.
     */
    void displayCreateListing();
    /**
     * Displays the account of active user.
     */
    void displayActiveAccount(ArrayList<SingleListingModel> listings,
                              ArrayList<ReviewModel> reviews, AccountModel account);
    /**
     * Displays the account of a user.
     */
    void displayAccount(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                        AccountModel account);
    /**
     * Displays the create-review page for a specified user
     */
    void displayCreateReview(String id);
    /**
     * Updates the current user using the app.
     */
    void setActiveUser(String id);
    /**
     * Retrieves the current user of the app.
     */
    String getActiveUser();
}
