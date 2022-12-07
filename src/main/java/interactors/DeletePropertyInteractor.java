package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.DeletePropertyInput;
import interactors.output_boundary.DeletePropertyOutput;

import java.util.ArrayList;

public class DeletePropertyInteractor implements DeletePropertyInput {

    PropertyGateway propertyGateway;
    DeletePropertyOutput deletePropertyOutput;

    public DeletePropertyInteractor(PropertyGateway g, DeletePropertyOutput ob) {
        this.propertyGateway = g;
        this.deletePropertyOutput = ob;
    }

    @Override
    public void deleteProperty(String id, String password) {
        ArrayList<Property> properties = this.propertyGateway.getProperties();
        for (Property p: properties) {
            if (p.getID().equals(id) && p.getOwner().getPassword().equals(password)) {
                this.propertyGateway.removePropertyById(id);
                this.deletePropertyOutput.onDeletePropertySuccess();
                return;
            }
        }
        this.deletePropertyOutput.onDeletePropertyFailure("Failed to delete property.");
    }
}
