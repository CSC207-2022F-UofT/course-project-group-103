package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.LoadListingInput;
import interactors.output_boundary.LoadListingOutput;

import java.util.ArrayList;

public class LoadListingInteractor implements LoadListingInput {

    PropertyGateway propertyGateway;
    LoadListingOutput loadListingOutput;

    public LoadListingInteractor(PropertyGateway g, LoadListingOutput ob) {
        this.propertyGateway = g;
        this.loadListingOutput = ob;
    }

    public void loadListing() {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        ArrayList<SingleListingModel> info = new ArrayList<>();
        for (Property p: properties) {
            info.add(new SingleListingModel(p.getID(), p.getAddress(), p.getPrice()));
        }
        this.loadListingOutput.onLoadListingSuccess(info);
    }
}
