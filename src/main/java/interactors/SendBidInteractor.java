package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.SendBidInput;
import interactors.output_boundary.SendBidOutput;

import java.util.ArrayList;

public class SendBidInteractor implements SendBidInput {

    PropertyGateway propertyGateway;
    SendBidOutput sendBidOutput;

    public SendBidInteractor(PropertyGateway g, SendBidOutput ob) {
        this.propertyGateway = g;
        this.sendBidOutput = ob;
    }

    public void sendBid(String propertyID, String bid, String bidderID) {
        ArrayList<Property> properties = propertyGateway.getProperties();
        for (Property p: properties) {
            if (p.getID().equals(propertyID)) {
                try {
                    p.addBid(Float.parseFloat(bid), bidderID);
                    this.propertyGateway.save(p);
                } catch (Exception e) {this.sendBidOutput.onSendBidFailure("Bid failed to save."); return;}
                this.sendBidOutput.onSendBidSuccess();
                return;
            }
        }
        this.sendBidOutput.onSendBidFailure("Invalid property ID");
    }
}
