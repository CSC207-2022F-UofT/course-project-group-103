package controllers;

import interactors.CreateListingInteractor;

public class CreateListingController {

    Presenter presenter;
    CreateListingInteractor createListingInteractor;

    public CreateListingController(Presenter p, CreateListingInteractor i) {
        this.presenter = p;
        this.createListingInteractor = i;
    }

    public void back() {
        this.presenter.displayPrevious();
    }

    public void sendCreateHouse(String name, String address, String sqFt, String price, String numBed,
                                String numBath, String numLaundry, String numKitchen) throws Exception {
        this.createListingInteractor.createHouse(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen);
    }

    public void sendCreateCondo(String name, String address, String sqFt, String price, String numBed,
                                String numBath, String numLaundry, String numKitchen) throws Exception {
        this.createListingInteractor.createCondo(name, address, sqFt, price, numBed, numBath, numLaundry, numKitchen);
    }
    public void sendCreateOffice(String name, String address, String sqFt, String price, String numOffice,
                                String numReception) throws Exception {
        this.createListingInteractor.createOffice(name, address, sqFt, price, numOffice, numReception);
    }

    public void sendCreateRestaurant(String name, String address, String sqFt, String price,
                                     String spec) throws Exception {
        this.createListingInteractor.createRestaurant(name, address, sqFt, price, spec);
    }

}
