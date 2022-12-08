package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.SendBidInput;
import interactors.output_boundary.SendBidOutput;

import java.util.ArrayList;

public class SendBidInteractor implements SendBidInput {

    /**
     * Gateway interface for the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Output interface for this interactor.
     */
    SendBidOutput sendBidOutput;

    /**
     * Constructor for the interactor, assigns its attributes.
     *
     * @param g: implementation of the property gateway interface.
     * @param ob: implementation of the output interface.
     */
    public SendBidInteractor(PropertyGateway g, SendBidOutput ob) {
        this.propertyGateway = g;
        this.sendBidOutput = ob;
    }

    /**
     * @see SendBidInput
     * adds the bid to the property associated with teh given property id and then saves the updated property
     * back to the database.
     */
    @Override
    public void sendBid(String propertyID, String bid, String bidderID) {
        ArrayList<Property> properties = propertyGateway.getProperties();
        for (Property p: properties) {
            if (p.getID().equals(propertyID)) {
                try {
                    float bid_float = Float.parseFloat(bid);
                    if (bid_float < Math.round(p.getPrice()*0.1)) {
                        this.sendBidOutput.onSendBidFailure("Bid at least 10% of asking price.");
                        return;
                    }
                    p.addBid(bid_float, bidderID);
                    this.propertyGateway.save(p);
                } catch (Exception e) {this.sendBidOutput.onSendBidFailure("Bid failed to save."); return;}
                this.sendBidOutput.onSendBidSuccess();
                return;
            }
        }
        this.sendBidOutput.onSendBidFailure("Invalid property ID");
    }
}
