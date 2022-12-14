package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.RefreshListingInput;
import interactors.output_boundary.RefreshListingOutput;

import java.util.ArrayList;

public class RefreshListingInteractor implements RefreshListingInput {

    /**
     * Gateway interface to the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Output interface for this interactor.
     */
    RefreshListingOutput refreshListingOutput;

    /**
     * Constructor for the interactor, assigns its attributes.
     *
     * @param g: implementation of the property gateway interface.
     * @param ob: implementation of the output interface.
     */
    public RefreshListingInteractor(PropertyGateway g, RefreshListingOutput ob) {
        this.propertyGateway = g;
        this.refreshListingOutput = ob;
    }

    /**
     * @see RefreshListingInput
     *
     * Accesses all properties and creates single listing models of all properties that meet the filter criteria,
     * then calls the output interface passing the single listing models.
     */
    @Override
    public void updateFilter(String price, String sqft, boolean house, boolean condo,
                      boolean office, boolean restaurant) {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        ArrayList<SingleListingModel> info = new ArrayList<>();
        float min_price;
        float max_price;
        int min_sqft;
        int max_sqft;
        try {
            min_price = Float.parseFloat(price.split("-")[0]);
            max_price = Float.parseFloat(price.split("-")[1]);
        } catch (Exception e) {
            this.refreshListingOutput.onUpdateFilterFailure("Invalid price range format.");
            return;
        }
        try {
            min_sqft = Integer.parseInt(sqft.split("-")[0]);
            max_sqft = Integer.parseInt(sqft.split("-")[1]);
        } catch (Exception e) {
            this.refreshListingOutput.onUpdateFilterFailure("Invalid price range format.");
            return;
        }
        for (Property p: properties) {
            if (p.getPrice() >= min_price && p.getPrice() <= max_price &&
                    p.getSqFt() >= min_sqft && p.getSqFt() <= max_sqft) {
                if ((p.getType().equals("House") && house) ||
                        (p.getType().equals("Condo") && condo) ||
                        (p.getType().equals("Office") && office) ||
                        (p.getType().equals("Restaurant") && restaurant)) {
                    info.add(new SingleListingModel(p.getID(), p.getAddress(), p.getPrice()));
                }
            }
        }
        this.refreshListingOutput.onUpdateFilterSuccess(info);
    }
}
