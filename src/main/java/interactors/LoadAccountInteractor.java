package interactors;

import entities.Property;
import entities.Review;
import entities.User;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.LoadAccountInput;
import interactors.output_boundary.LoadAccountOutput;

import java.util.ArrayList;

public class LoadAccountInteractor implements LoadAccountInput {

    /**
     * Gateway interface to the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Gateway interface to the review database.
     */
    ReviewGateway reviewGateway;
    /**
     * Output interface for this interactor.
     */
    LoadAccountOutput loadAccountOutput;

    /**
     * Constructor for this interactor, assigns its attributes.
     *
     * @param g: implementation of the property gateway interface.
     * @param rg: implementation of the review gateway interface.
     * @param ob: implementation of the interactor output interface.
     */
    public LoadAccountInteractor(PropertyGateway g, ReviewGateway rg, LoadAccountOutput ob) {
        this.propertyGateway = g;
        this.reviewGateway = rg;
        this.loadAccountOutput = ob;
    }

    /**
     * @see LoadAccountInput
     * Loads the user associated with the given ID and then creates the relevant info objects, then calls
     * the output interface method passing the relevant info objects in.
     */
    @Override
    public void loadAccount(String id) {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        ArrayList<SingleListingModel> account_listings = new ArrayList<>();
        for (Property p: properties) {
            if (p.getOwner().getID().equals(id)) {
                account_listings.add(new SingleListingModel(p.getID(), p.getAddress(), p.getPrice()));
            }
        }
        ArrayList<Review> reviews = this.reviewGateway.getReviews();
        ArrayList<ReviewModel> account_reviews = new ArrayList<>();
        for (Review r: reviews) {
            if (r.getOwner().equals(id)) {
                try {
                    account_reviews.add(new ReviewModel(r.getReview(),
                            r.getRating(), this.propertyGateway.getUser(r.getUser()).getName(), r.getDate()));
                } catch (Exception e) {this.loadAccountOutput.onLoadAccountFailure("Failed to load review.");}
            }
        }
        try {
            User u = this.propertyGateway.getUser(id);
            AccountModel account = new AccountModel(u.getName(), id, u.getContact());
            this.loadAccountOutput.onLoadAccountSuccess(account_listings, account_reviews, account);
        } catch (Exception e) {this.loadAccountOutput.onLoadAccountFailure("Failed to load account info.");}
    }
}
