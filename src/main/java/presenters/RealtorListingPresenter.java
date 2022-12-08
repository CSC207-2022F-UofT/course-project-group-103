package presenters;

import interactors.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class RealtorListingPresenter {
    RealtorSearchInteractor realtorSearchInteractor;
    ViewInterface viewInterface;

    public RealtorListingPresenter(RealtorSearchInteractor i, ViewInterface p) {
        this.realtorSearchInteractor = i;
        this.viewInterface = p;
    }

    public ArrayList<ArrayList<String>> realtors(){
        return realtorSearchInteractor.listRealtors();
    }

    public void realtorHire() {
        this.viewInterface.displayHome();
        this.viewInterface.displaySuccess("Successfully hired realtor");
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }

}
