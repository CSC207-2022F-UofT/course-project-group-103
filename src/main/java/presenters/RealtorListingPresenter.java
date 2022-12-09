package presenters;

import interactors.HireRealtorInteractor;
import interactors.gateway_interfaces.LoginGateway;
import interactors.input_boundary.HireRealtorInput;
import interactors.output_boundary.HireRealtorOutput;

public class RealtorListingPresenter implements HireRealtorOutput {

    /**
     * Interface for presenter to interact with view.
     */
    ViewInterface viewInterface;
    /**
     * Interface for presenter to interact with use case.
     */
    HireRealtorInput hireRealtorInput;

    /**
     * Constructor for this presenter, assigns the view interface and creates its use case interactors.
     *
     * @param p: implementation of the view interface.
     * @param g: implementation of the login gateway.
     */
    public RealtorListingPresenter(ViewInterface p, LoginGateway g) {
        this.viewInterface = p;
        this.hireRealtorInput = new HireRealtorInteractor(g, this);
    }

    /**
     * Called when the user input to go to hire a realtor. Calls the hire realtor input method passing in
     * the id of the realtor and the user.
     *
     * @param realtorID: id of the realtor to hire.
     */
    public void onHireRealtor(String realtorID) {
        this.hireRealtorInput.hireRealtor(this.viewInterface.getActiveUser(), realtorID);
    }

    /**
     * @see HireRealtorOutput
     * Tells the view to display a success message.
     */
    @Override
    public void onHireRealtorSuccess() {
        this.viewInterface.displaySuccess("Realtor Hired.");
    }

    /**
     * @see HireRealtorOutput
     * Tells the view to display a failure message passing in the message.
     */
    public void onHireRealtorFailure(String message) {
        this.viewInterface.displayFailure("Hire realtor failed.");
    }

    /**
     * Called when the user input to go to the previous page is given. Tells the view
     * to display the previous page.
     */
    public void onBack() {
        this.viewInterface.displayPrevious();
    }

}
