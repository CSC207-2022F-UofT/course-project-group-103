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

    PropertyGateway propertyGateway;
    LoginGateway loginGateway;
    ReviewGateway reviewGateway;
    DeleteAccountOutput deleteAccountOutput;

    public DeleteAccountInteractor(PropertyGateway pg, LoginGateway lg,
                                        ReviewGateway rg, DeleteAccountOutput ob) {
        this.propertyGateway = pg;
        this.loginGateway = lg;
        this.reviewGateway = rg;
        this.deleteAccountOutput = ob;
    }

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
