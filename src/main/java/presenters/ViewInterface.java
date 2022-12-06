package presenters;

// controller layer
public interface ViewInterface {
    /**
     * Displays the home page.
     */
    void displayHome();
    /**
     * Displays a property page.
     */
    void displayProperty();
    /**
     * Displays the login page.
     */
    void displayLogin();
    /**
     * Displays the sign-up page.
     */
    void displaySignUp();
    /**
     * Displays the listing page.
     */
    void displayListing();
    /**
     * Displays the account page.
     */
    void displayAccount();
    /**
     * Displays the active user account page.
     */
    void displayActiveAccount();
    /**
     * Displays the create listing page.
     */
    void displayCreateListing();
    /**
     * Displays the create review page.
     */
    void displayCreateReview();
    /**
     * Displays the previous page.
     */
    void displayPrevious();
    /**
     * Clears the order of pages.
     */
    void clearPrevious();
    /**
     * Refreshes the account page.
     */
    void refreshAccount();
}
