package presenters;

import interactors.CreateListingInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.PropertyGateway;
import interactors.input_boundary.CreateListingInput;
import interactors.output_boundary.CreateListingOutput;

public class CreateListingPresenter implements CreateListingOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with use case.
     */
    CreateListingInput createListingInput;

    /**
     * Constructor this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param view: implementation of the view interface.
     * @param g: implementation of the property gateway interface.
     * @param l: implementation of the login gateway interface.
     */
    public CreateListingPresenter(ViewInterface view, PropertyGateway g, LoginGateway l) {
        this.viewInterface = view;
        this.createListingInput = new CreateListingInteractor(g, l, this);
    }

    /**
     * Called when the user input to go to the previous page is given. Tells the view
     * to display the previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    /**
     * Called when the user input create new house. Calls the create listing input method create
     * house passing in all the parameters.
     *
     * @param name: name to create
     * @param address: address to create
     * @param sqFt: square footage to create
     * @param price: price to create
     * @param numBed: number of bedrooms to create
     * @param numBath: number of bathrooms to create
     * @param numLaundry: number of laundry rooms to create
     * @param numKitchen: number of kitchens to create
     */
    public void onCreateHouse(String name, String address, String sqFt, String price, String numBed,
                              String numBath, String numLaundry, String numKitchen) {
        this.createListingInput.createHouse(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen,
                this.viewInterface.getActiveUser());
    }
    /**
     * Called when the user input create new condo. Calls the create listing input method create
     * condo passing in all the parameters.
     *
     * @param name: name to create
     * @param address: address to create
     * @param sqFt: square footage to create
     * @param price: price to create
     * @param numBed: number of bedrooms to create
     * @param numBath: number of bathrooms to create
     * @param numLaundry: number of laundry rooms to create
     * @param numKitchen: number of kitchens to create
     */
    public void onCreateCondo(String name, String address, String sqFt, String price, String numBed,
                              String numBath, String numLaundry, String numKitchen) {
        this.createListingInput.createCondo(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen,
                this.viewInterface.getActiveUser());
    }

    /**
     * Called when the user input create new office. Calls the create listing input method create
     * house passing in all the parameters.
     *
     * @param name: name to create
     * @param address: address to create
     * @param sqFt: square footage to create
     * @param price: price to create
     * @param numOffice: number of office rooms to create
     * @param numReception: number of receptions to create
     */
    public void onCreateOffice(String name, String address, String sqFt, String price, String numOffice,
                               String numReception) {
        this.createListingInput.createOffice(name, address, sqFt, price, numOffice, numReception,
                this.viewInterface.getActiveUser());
    }

    /**
     * Called when the user input create new restaurant. Calls the create listing input method create
     * house passing in all the parameters.
     *
     * @param name: name to create
     * @param address: address to create
     * @param sqFt: square footage to create
     * @param price: price to create
     * @param spec: kitchen speecifications to create
     */
    public void onCreateRestaurant(String name, String address, String sqFt, String price,
                                   String spec) {
        this.createListingInput.createRestaurant(name, address, sqFt, price, spec, this.viewInterface.getActiveUser());
    }

    /**
     * @see CreateListingOutput
     * Tells the view to display a success message and then go back to the previous page.
     */
    @Override
    public void onCreateListingSuccess() {
        this.viewInterface.displaySuccess("Listing created.");
        this.viewInterface.displayPrevious();
    }

    /**
     * @see CreateListingOutput
     * Tells the view to display a failure message passing in the failure message.
     */
    @Override
    public void onCreateListingFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

}
