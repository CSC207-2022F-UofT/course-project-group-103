package presenters;

import interactors.SingleListingInteractor;
import java.util.ArrayList;

public class SingleListingPresenter {
    SingleListingInteractor singleListingInteractor;
    ViewInterface viewInterface;

    public SingleListingPresenter(SingleListingInteractor i, ViewInterface p) {
        this.singleListingInteractor = i;
        this.viewInterface = p;
    }

    /**
     * Returns a list of basic info on a property.
     *
     * Calls the SingleListingInteractor method listingInfo().
     */
    public ArrayList<String> onListingInfo() {
        return this.singleListingInteractor.listingInfo();
    }

    /**
     * Displays property page.
     *
     * Calls the presenter method to display property implemented in GUI.
     */
    public void onShowProperty() {
        this.singleListingInteractor.updateDisplayProperty();
        this.viewInterface.displayProperty();
    }
}
