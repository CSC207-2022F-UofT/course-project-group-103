package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.LoadListingInput;
import interactors.output_boundary.LoadListingOutput;

import java.util.ArrayList;

public class LoadListingInteractor implements LoadListingInput {

    /**
     * Gateway interface to the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Output interface for this interactor.
     */
    LoadListingOutput loadListingOutput;

    /**
     * Constructor for this interactor, assigns its attributes.
     *
     * @param g: implementation of the property gateway interface.
     * @param ob: implementation of the interactor output interface.
     */
    public LoadListingInteractor(PropertyGateway g, LoadListingOutput ob) {
        this.propertyGateway = g;
        this.loadListingOutput = ob;
    }

    /**
     * @see LoadListingInput
     * Accesses all property objects stored in the database and creates single listing models from their
     * information, then calls the output interface method passing in the single listings models.
     */
    @Override
    public void loadListing() {
        try {
            ArrayList<Property> properties = this.propertyGateway.getProperties();
            ArrayList<SingleListingModel> info = new ArrayList<>();
            for (Property p: properties) {
                info.add(new SingleListingModel(p.getID(), p.getAddress(), p.getPrice()));
            }
            this.loadListingOutput.onLoadListingSuccess(info);
        } catch (Exception e) {this.loadListingOutput.onLoadListingFailure("Failed to load listings.");}
    }
}
