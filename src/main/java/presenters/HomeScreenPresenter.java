package presenters;

public class HomeScreenPresenter {

    ViewInterface viewInterface;

    public HomeScreenPresenter(ViewInterface p) {
        this.viewInterface = p;
    }

    /**
     * Displays listing page.
     *
     * Calls presenter method to display the listing page which is implemented in the GUI class.
     */
    public void onListing() {
        this.viewInterface.displayListing();
    }

    /**
     * Displays account page
     *
     * Calls presenter method to display the account poge which is implemented in the GUI class.
     */
    public void onAccount() {
        this.viewInterface.displayActiveAccount();
    }

    /**
     * Displays create listing page
     *
     * Calls presenter method to display the create listing poge which is implemented in the GUI class.
     */
    public void onCreateListing() {
        this.viewInterface.displayCreateListing();
    }

    public void onRealtorListing() {
        this.viewInterface.displayRealtorListing();
    }
}
