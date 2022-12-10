package interactors;

import entities.User;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.HireRealtorInput;
import interactors.output_boundary.HireRealtorOutput;

import java.util.ArrayList;
import java.util.Objects;

public class HireRealtorInteractor implements HireRealtorInput {

    /**
     * Gateway interface to the user database.
     */
    LoginGateway loginGateway;
    /**
     * Output interface for this interactor.
     */
    HireRealtorOutput hireRealtorOutput;

    /**
     * Constructor for this interactor, assigns its attributes.
     *
     * @param g: implementation of the login gateway interface.
     * @param ob: implementation of the output interface.
     */
    public HireRealtorInteractor(LoginGateway g, HireRealtorOutput ob) {
        this.loginGateway =  g;
        this.hireRealtorOutput = ob;
    }

    /**
     * Hires a realtor to a specified user.
     *
     * @param userID: id of the user that is hiring.
     * @param realtorID: id of the realtor to hire.
     */
    public void hireRealtor(String userID, String realtorID) {
        try {
            ArrayList<User> users = this.loginGateway.getUsers();
            for (User u: users) {
                if (u.getID().equals(userID)) {
                    if (u.getHiredRealtorID().equals(realtorID)) {
                        this.hireRealtorOutput.onHireRealtorFailure("You have already hired this realtor.");
                        return;
                    }
                    u.hireRealtor(realtorID);
                    this.loginGateway.saveUser(u);
                    this.hireRealtorOutput.onHireRealtorSuccess();
                    return;
                }
            }
        } catch (Exception e) {this.hireRealtorOutput.onHireRealtorFailure("Failed to hire realtor.");}
    }
}
