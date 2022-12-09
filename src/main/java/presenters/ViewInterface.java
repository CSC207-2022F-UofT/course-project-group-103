package presenters;

import interactors.*;

import java.util.ArrayList;

public interface ViewInterface {
    /**
     * Displays the login page.
     */
    void displayLogin();
    /**
     * Displays a failure message.
     *
     * @param message: failure message.
     */
    void displayFailure(String message);
    /**
     * Displays a success message.
     *
     * @param message: success message.
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
     *
     * @param info: single listing models to display.
     */
    void refreshListing(ArrayList<SingleListingModel> info);
    /**
     * Displays the property page.
     *
     * @param property: property model to display
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
     *
     * @param listings: single listing models to display.
     * @param reviews: review models to display.
     * @param account: account model to display.
     */
    void displayActiveAccount(ArrayList<SingleListingModel> listings,
                              ArrayList<ReviewModel> reviews, AccountModel account);
    /**
     * Displays the account of a user.
     *
     * @param listings: listing models to display.
     * @param reviews: review models to display.
     * @param account: account model to display.
     */
    void displayAccount(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                        AccountModel account);
    /**
     * Displays the create-review page for a specified user
     *
     * @param id: id of user being reviewed
     */
    void displayCreateReview(String id);
    /**
     * Updates the current user using the app.
     *
     * @param id: id to set active user.
     */
    void setActiveUser(String id);
    /**
     * Retrieves the current user of the app.
     *
     * @return id of active user.
     */
    String getActiveUser();

    /**
     * Displays the realtor listing page.
     *
     * @param realtors: Array list of single realtor models to display.
     */
    void displayRealtorListing(ArrayList<SingleRealtorModel> realtors);
    /**
     * Displays the mortgage estimator page for a specific property.
     */
    void displayMortgageEstimator(float price);
}
