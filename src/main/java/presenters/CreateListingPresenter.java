package presenters;

import interactors.CreateListingInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.CreateListingInput;
import interactors.output_boundary.CreateListingOutput;

public class CreateListingPresenter implements CreateListingOutput {

    ViewInterface viewInterface;
    CreateListingInput createListingInput;

    public CreateListingPresenter(ViewInterface view, PropertyGateway g, LoginGateway l) {
        this.viewInterface = view;
        this.createListingInput = new CreateListingInteractor(g, l, this);
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    public void onCreateHouse(String name, String address, String sqFt, String price, String numBed,
                              String numBath, String numLaundry, String numKitchen) {
        this.createListingInput.createHouse(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen,
                this.viewInterface.getActiveUser());
    }

    public void onCreateCondo(String name, String address, String sqFt, String price, String numBed,
                              String numBath, String numLaundry, String numKitchen) {
        this.createListingInput.createCondo(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen,
                this.viewInterface.getActiveUser());
    }
    public void onCreateOffice(String name, String address, String sqFt, String price, String numOffice,
                               String numReception) {
        this.createListingInput.createOffice(name, address, sqFt, price, numOffice, numReception,
                this.viewInterface.getActiveUser());
    }

    public void onCreateRestaurant(String name, String address, String sqFt, String price,
                                   String spec) {
        this.createListingInput.createRestaurant(name, address, sqFt, price, spec, this.viewInterface.getActiveUser());
    }

    public void onCreateListingSuccess() {
        this.viewInterface.displaySuccess("Listing created.");
        this.viewInterface.displayPrevious();
    }

    public void onCreateListingFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

}
