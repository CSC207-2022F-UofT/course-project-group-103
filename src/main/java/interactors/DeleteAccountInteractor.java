package interactors;

import entities.Property;
import entities.Review;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.gateway_interfaces.ReviewGateway;
import interactors.input_boundary.DeleteAccountInput;
import interactors.output_boundary.DeleteAccountOutput;
import java.util.ArrayList;

public class DeleteAccountInteractor implements DeleteAccountInput {

    /**
     * Gateway interface to the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Gateway interface for the user's database.
     */
    LoginGateway loginGateway;
    /**
     * Gateway interface for the review's database.
     */
    ReviewGateway reviewGateway;
    /**
     * Output interface for this interactor.
     */
    DeleteAccountOutput deleteAccountOutput;

    /**
     * Constructor for the interactor, assigns its attributes.
     *
     * @param pg: implementation of the property gateway interface.
     * @param lg: implementation of the login gateway interface.
     * @param rg: implementation of the review gateway interface.
     * @param ob: implementation of the interactor's output interface.
     */
    public DeleteAccountInteractor(PropertyGateway pg, LoginGateway lg,
                                        ReviewGateway rg, DeleteAccountOutput ob) {
        this.propertyGateway = pg;
        this.loginGateway = lg;
        this.reviewGateway = rg;
        this.deleteAccountOutput = ob;
    }

    /**
     * @see DeleteAccountInput
     *
     * Deletes all properties listed by user in the database, deletes all bids given by the user, deletes all
     * reviews made by the user and then delete the user account from the database.
     */
    @Override
    public void deleteAccount(String id, String password) {
        try {
            if (!this.propertyGateway.getUser(id).getPassword().equals(password)) {
                this.deleteAccountOutput.onDeleteAccountFailure("Passwords do not match.");
                return;
            }
        } catch (Exception e) {this.deleteAccountOutput.onDeleteAccountFailure("Failed to verify password."); return;}

        ArrayList<Review> reviews = this.reviewGateway.getReviews();
        for (Review r: reviews) {
            if (r.getUser().equals(id)) {
                try {
                    this.reviewGateway.deleteReview(r.getID());
                } catch (Exception e) {
                    this.deleteAccountOutput.onDeleteAccountFailure("Failed to delete reviews.");
                    return;
                }
            }
        }
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        for (Property p: properties) {
            try {
                for (String bidID: p.getBids().keySet()) {
                    if (bidID.equals(id)) {
                        p.removeBid(id);
                        this.propertyGateway.save(p);
                    }
                }
            } catch (Exception e) {this.deleteAccountOutput.onDeleteAccountFailure("Failed to delete bids"); return;}
            if (p.getOwner().getID().equals(id)) {
                this.propertyGateway.removePropertyById(p.getID());
            }
        }
        this.loginGateway.removeUser(id);
        this.deleteAccountOutput.onDeleteAccountSuccess();
    }

}
