package interactors;

import entities.User;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.LoadRealtorsInput;
import interactors.output_boundary.LoadRealtorsOutput;

import java.util.ArrayList;

public class LoadRealtorsInteractor implements LoadRealtorsInput {

    /**
     * Gateway interface to the user database.
     */
    LoginGateway loginGateway;
    /**
     * Output interface for this interact.
     */
    LoadRealtorsOutput loadRealtorsOutput;

    /**
     * Constructor for this interactor, assigns its attributes.
     *
     * @param g: implementation of the login gateway interface
     * @param ob: implementation of the output interface
     */
    public LoadRealtorsInteractor(LoginGateway g, LoadRealtorsOutput ob) {
        this.loginGateway = g;
        this.loadRealtorsOutput = ob;
    }

    /**
     * @see LoadRealtorsInput
     * Retrieves all users and creates a list of single review models to be passed to the output.
     */
    public void loadRealtors() {
        try {
            ArrayList<User> users = this.loginGateway.getUsers();
            ArrayList<SingleRealtorModel> realtors = new ArrayList<>();
            for (User u: users) {
                if (u.getClass().getName().replace("entities.", "").equals("Realtor")) {
                    realtors.add(new SingleRealtorModel(u.getName(), u.getContact(), u.getID()));
                }
            }
            this.loadRealtorsOutput.onLoadRealtorsSuccess(realtors);
        } catch(Exception e) {this.loadRealtorsOutput.onLoadRealtorsFailure("Failed to load realtors.");}
    }

}
