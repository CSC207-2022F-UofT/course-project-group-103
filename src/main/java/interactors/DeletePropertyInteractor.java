package interactors;

import entities.Property;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.DeletePropertyInput;
import interactors.output_boundary.DeletePropertyOutput;

import java.util.ArrayList;

public class DeletePropertyInteractor implements DeletePropertyInput {

    /**
     * Gateway interface to the property database.
     */
    PropertyGateway propertyGateway;
    /**
     * Output interface of this interactor.
     */
    DeletePropertyOutput deletePropertyOutput;

    /**
     * Constructor for the interactor, assigns its attributes.
     *
     * @param g: implementation of the property gateway interface.
     * @param ob: implementation of the interactor output interface
     */
    public DeletePropertyInteractor(PropertyGateway g, DeletePropertyOutput ob) {
        this.propertyGateway = g;
        this.deletePropertyOutput = ob;
    }

    /**
     * @see DeletePropertyInput
     *
     * Deletes the property associated with the ID from the database after checking if the
     * property owner's password and the given password match.
     */
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
