package interactors;

import entities.Property;
import entities.Review;
import interactors.containers.*;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;

import java.util.ArrayList;

public class ActiveAccountInteractor {

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
     * Gateway interface to user JSON with read/write methods.
     */
    LoginGateway loginGateway;
    /**
     * Gateway interface to review JSON with read/write methods.
     */
    ReviewGateway reviewGateway;

    /**
     * Constructor for the account interactor, assigns object instances to its attributes.
     *
     * @param u: ActiveUser class for this application instance's current active user.
     * @param p: PropertyToDisplay class for this application instance's property being accessed
     * @param g: implementation of propertyGateway interface.
     * @param lg: implementation of loginGateway interface.
     * @param rg: implementation of reviewGateway interface.
     */
    public ActiveAccountInteractor(ActiveUser u, PropertyToDisplay p, PropertyGateway g,
                                   LoginGateway lg, ReviewGateway rg) {
        this.activeUser = u;
        this.propertyToDisplay = p;
        this.propertyGateway = g;
        this.loginGateway = lg;
        this.reviewGateway = rg;
    }

    /**
     * Creates an array list of single listing interactors for properties the active account owns
     * to be passed to the presenter.
     * @return array list of SingleListingInteractors
     */
    public ArrayList<SingleListingInteractor> createUserProperties() {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        ArrayList<SingleListingInteractor> interactors = new ArrayList<>();
        for (Property p: properties) {
            if (p.getOwner().getID().equals(this.activeUser.getActiveUser().getID())) {
                interactors.add(new SingleListingInteractor(p, propertyToDisplay));
            }
        }
        return interactors;
    }

    /**
     * Creates an array list of single review interactors for reviews on the active account to be passed to
     * the presenter.
     * @return array list of SingleReviewInteractors
     */
    public ArrayList<SingleReviewInteractor> createUserReviews() {
        ArrayList<Review> reviews = this.reviewGateway.getReviews();
        ArrayList<SingleReviewInteractor> interactors = new ArrayList<>();
        for (Review r: reviews) {
            if (r.getOwner().equals(this.activeUser.getActiveUser().getID())) {
                interactors.add(new SingleReviewInteractor(r, propertyGateway));
            }
        }
        return interactors;
    }

    /**
     * Creates an array list of strings representing basic info of the active account such as name and contact
     * information.
     * @return array list of formatted string representations of relevant account attributes.
     */
    public ArrayList<String> getInfo() {
        if (this.activeUser.getActiveUser()!=null) {
            ArrayList<String> info = new ArrayList<>();
            info.add("Name: " + this.activeUser.getActiveUser().getName());
            info.add("Contact: " + this.activeUser.getActiveUser().getContact());
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
        if (this.activeUser.getActiveUser()!=null) {
            return this.activeUser.getActiveUser().getClass().getName().replace(
                    "entities.", "").equals("Owner");
        }
        return false;
    }

    /**
     * Signs owner out by changing the active user in the model to null.
     */
    public void signOut() {
        this.activeUser.setActiveUser(null);
    }

    /**
     * Deletes the active users account if they enter the correct password for their account. Deletes their
     * user entry in userListing.json and all their listed properties in propertyListing.json.
     *
     * @param password: password for the active account.
     */
    public void deleteAccount(String password) throws Exception {
        if (!password.equals(this.activeUser.getActiveUser().getPassword())) {
            throw new Exception("Incorrect Password");
        }
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        for (Property p: properties) {
            if (p.getOwner().getID().equals(this.activeUser.getActiveUser().getID())) {
                this.propertyGateway.removePropertyById(p.getID());
            }
        }
        this.loginGateway.removeUser(activeUser.getActiveUser().getID());
        this.activeUser.setActiveUser(null);
    }
}
