package Screens;

import Exceptions.UndefinedPropertyType;
import Interactors.AccessSinglePropertyInteractor;

import java.util.ArrayList;

public class SinglePropertyPageScreenController {

    AccessSinglePropertyInteractor accessSinglePropertyInteractor;

    public SinglePropertyPageScreenController(AccessSinglePropertyInteractor interactor) {
        this.accessSinglePropertyInteractor = interactor;
    }

    public String getName() throws  UndefinedPropertyType {
        return this.accessSinglePropertyInteractor.access_single_property().getName();
    }

    public ArrayList<String> getInfo() throws UndefinedPropertyType {
        return this.accessSinglePropertyInteractor.access_single_property().info();
    }

    public ArrayList<String> getOwnerInfo() throws UndefinedPropertyType {
        return this.accessSinglePropertyInteractor.access_single_property().getOwner().info();
    }


}
