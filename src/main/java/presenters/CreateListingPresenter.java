package presenters;

import interactors.CreateListingInteractor;

public class CreateListingPresenter {

    ViewInterface viewInterface;
    CreateListingInteractor createListingInteractor;

    public CreateListingPresenter(ViewInterface p, CreateListingInteractor i) {
        this.viewInterface = p;
        this.createListingInteractor = i;
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }

    public void onCreateHouse(String name, String address, String sqFt, String price, String numBed,
                                String numBath, String numLaundry, String numKitchen) throws Exception {
        this.createListingInteractor.createHouse(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen);
        this.viewInterface.displayPrevious();
    }

    public void onCreateCondo(String name, String address, String sqFt, String price, String numBed,
                                String numBath, String numLaundry, String numKitchen) throws Exception {
        this.createListingInteractor.createCondo(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen);
        this.viewInterface.displayPrevious();
    }
    public void onCreateOffice(String name, String address, String sqFt, String price, String numOffice,
                                String numReception) throws Exception {
        this.createListingInteractor.createOffice(name, address, sqFt, price, numOffice, numReception);
        this.viewInterface.displayPrevious();
    }

    public void onCreateRestaurant(String name, String address, String sqFt, String price,
                                     String spec) throws Exception {
        this.createListingInteractor.createRestaurant(name, address, sqFt, price, spec);
        this.viewInterface.displayPrevious();
    }

}
