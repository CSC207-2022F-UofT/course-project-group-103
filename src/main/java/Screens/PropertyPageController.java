package Screens;

import Interactors.PropertyPageInteractor;
import java.util.ArrayList;

public class PropertyPageController {
    PropertyPageInteractor propertyPageInteractor;

    public PropertyPageController(PropertyPageInteractor interactor) {
        this.propertyPageInteractor = interactor;
    }

    public ArrayList<String> getInfoList() {
        return this.propertyPageInteractor.propertyInfo();
    }

    public void sendBid(String bid) throws Exception {
        this.propertyPageInteractor.sendBid(bid);
    }
}
