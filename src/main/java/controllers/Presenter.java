package controllers;

// controller layer
public interface Presenter {
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
     * Displays the previous page.
     */
    void displayPrevious();
}
