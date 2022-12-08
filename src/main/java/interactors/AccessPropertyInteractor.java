package interactors;

import entities.Property;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.AccessPropertyInput;
import interactors.output_boundary.AccessPropertyOutput;

import java.util.ArrayList;

public class AccessPropertyInteractor implements AccessPropertyInput {

    PropertyGateway propertyGateway;
    LoginGateway loginGateway;
    AccessPropertyOutput accessPropertyOutput;

    public AccessPropertyInteractor(PropertyGateway g, LoginGateway l, AccessPropertyOutput ob) {
        this.propertyGateway = g;
        this.loginGateway = l;
        this.accessPropertyOutput = ob;

    }
    public void accessProperty(String PropertyID) {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        for (Property p: properties) {
            if (p.getID().equals(PropertyID)) {
                ArrayList<BidModel> property_bids = new ArrayList<>();
                for (String k: p.getBids().keySet()) {
                    try {
                        property_bids.add(new BidModel(k, this.loginGateway.getUser(k).getName(), p.getBids().get(k)));
                    } catch (Exception e) {this.accessPropertyOutput.onAccessPropertyFailure("Failed to get bids.");};
                }
                PropertyModel model = new PropertyModel(p, property_bids);
                this.accessPropertyOutput.onAccessPropertySuccess(model);
                return;
            }
        }
        this.accessPropertyOutput.onAccessPropertyFailure("Failed to load property.");
    }
}
