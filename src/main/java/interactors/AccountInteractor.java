package interactors;

import entities.Property;
import entities.Review;
import interactors.containers.*;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;

import java.util.ArrayList;

public class AccountInteractor {

    /**
     * Current account being accessed.
     */
    AccountToDisplay accountToDisplay;
    /**
     * Current user of the application.
     */
    ActiveUser activeUser;
    /**
     * Current property being accessed.
     */
    PropertyToDisplay propertyToDisplay;
    /**
     * Gateway interface to property JSON with read/write methods.
     */
    PropertyGateway propertyGateway;
    /**
     * Gateway interface to review JSON with read/write methods.
     */
    ReviewGateway reviewGateway;

    /**
     * Constructor for the account interactor, assigns object instances to its attributes.
     *
     * @param a: AccountToDisplay class for this application instance's account being accessed.
     * @param u: ActiveUser class for this application instance's current active user.
     * @param p: PropertyToDisplay class for this application instance's property being accessed
     * @param g: implementation of propertyGateway interface.
     * @param gr: implementation of reviewGateway interface.
     */
    public AccountInteractor(AccountToDisplay a, ActiveUser u, PropertyToDisplay p,
                             PropertyGateway g, ReviewGateway gr) {
        this.accountToDisplay = a;
        this.activeUser = u;
        this.propertyToDisplay = p;
        this.propertyGateway = g;
        this.reviewGateway = gr;
    }

    /**
     * Creates an array list of single listing interactors for properties the accessed account owns
     * to be passed to the presenter.
     * @return array list of SingleListingInteractors
     */
    public ArrayList<SingleListingInteractor> createUserProperties() {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        ArrayList<SingleListingInteractor> interactors = new ArrayList<>();
        for (Property p: properties) {
            if (p.getOwner().getID().equals(this.accountToDisplay.getAccountDisplay().getID())) {
                interactors.add(new SingleListingInteractor(p, propertyToDisplay));
            }
        }
        return interactors;
    }

    /**
     * Creates an array list of single review interactors for reviews on the accessed account to be passed
     * to the presenter.
     * @return array list of SingleReviewInteractors
     */
    public ArrayList<SingleReviewInteractor> createUserReviews() {
        ArrayList<Review> reviews = this.reviewGateway.getReviews();
        ArrayList<SingleReviewInteractor> interactors = new ArrayList<>();
        for (Review r: reviews) {
            if (r.getOwner().equals(this.accountToDisplay.getAccountDisplay().getID())) {
                interactors.add(new SingleReviewInteractor(r, propertyGateway));
            }
        }
        return interactors;
    }

    /**
     * Creates an array list of strings representing basic info of the accessed account such as name and contact
     * information.
     * @return array list of formatted string representations of relevant account attributes.
     */
    public ArrayList<String> getInfo() {
        if (this.accountToDisplay.getAccountDisplay()!=null) {
            ArrayList<String> info = new ArrayList<>();
            info.add("Name: " + this.accountToDisplay.getAccountDisplay().getName());
            info.add("Contact: " + this.accountToDisplay.getAccountDisplay().getContact());
            return info;
        }
        ArrayList<String> empty = new ArrayList<>();
        empty.add("error");
        return empty;
    }

    /**
     * Returns whether the accessed account is of an owner.
     * @return boolean of whether accessed account is owner (true) or not (false).
     */
    public boolean isOwnerType() {
        if (this.accountToDisplay.getAccountDisplay()!=null) {
            return this.accountToDisplay.getAccountDisplay().getClass().getName().replace(
                    "entities.", "").equals("Owner");
        }
        return false;
    }
}
