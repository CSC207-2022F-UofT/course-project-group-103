package interactors;

import entities.Property;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.AccessPropertyInput;
import interactors.output_boundary.AccessPropertyOutput;

import java.util.ArrayList;

public class AccessPropertyInteractor implements AccessPropertyInput {

    /**
     * Gateway interface to the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Gateway interface to the user database.
     */
    LoginGateway loginGateway;
    /**
     * Output interface for this interactor.
     */
    AccessPropertyOutput accessPropertyOutput;

    /**
     * Constructor for this interactor, assigns the attributes.
     *
     * @param g: implementation of the property gateway.
     * @param l: implementation of the login gateway.
     * @param ob: implementation of the output interface.
     */
    public AccessPropertyInteractor(PropertyGateway g, LoginGateway l, AccessPropertyOutput ob) {
        this.propertyGateway = g;
        this.loginGateway = l;
        this.accessPropertyOutput = ob;

    }

    /**
     * @see AccessPropertyInput
     *
     * Gets an arraylist of all property objects in the database from the gateway and then finds the property
     * associated with the ID. Once the property is found, a PropertyModel is created and the output is called.
     */
    @Override
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
