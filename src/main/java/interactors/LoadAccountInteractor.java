package interactors;

import entities.Property;
import entities.Review;
import entities.User;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.LoadAccountInput;
import interactors.output_boundary.LoadAccountOutput;

import java.util.ArrayList;

public class LoadAccountInteractor implements LoadAccountInput {

    PropertyGateway propertyGateway;
    LoginGateway loginGateway;
    ReviewGateway reviewGateway;
    LoadAccountOutput loadAccountOutput;

    public LoadAccountInteractor(PropertyGateway g, LoginGateway lg, ReviewGateway rg, LoadAccountOutput ob) {
        this.propertyGateway = g;
        this.loginGateway = lg;
        this.reviewGateway = rg;
        this.loadAccountOutput = ob;
    }

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
                            r.getRating(), this.loginGateway.getUser(r.getUser()).getName(), r.getDate()));
                } catch (Exception e) {this.loadAccountOutput.onLoadAccountFailure("Failed to load review.");}
            }
        }
        try {
            User u = this.loginGateway.getUser(id);
            AccountModel account = new AccountModel(u.getName(), id, u.getContact(), u.getSecurityQuestion(),
                    u.getSecurityAnswer());
            this.loadAccountOutput.onLoadAccountSuccess(account_listings, account_reviews, account);
        } catch (Exception e) {this.loadAccountOutput.onLoadAccountFailure("Failed to load account info.");}
    }
}
