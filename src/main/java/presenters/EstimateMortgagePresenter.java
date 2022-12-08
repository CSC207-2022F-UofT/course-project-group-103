package presenters;


import interactors.EstimateMortgageInteractor;
import interactors.input_boundary.EstimateMortgageInput;
import interactors.output_boundary.EstimateMortgageOutput;

public class EstimateMortgagePresenter implements EstimateMortgageOutput {

    ViewInterface viewInterface;
    EstimateMortgageInput estimateMortgageInput;
    public EstimateMortgagePresenter(ViewInterface p) {
        viewInterface = p;
        estimateMortgageInput = new EstimateMortgageInteractor(this);
    }

    /**
     * Estimates the mortgage by passing user enetered information to the interactor
     * @param price price of the property
     * @param downpayment downpayment as provided by the user
     * @param rate rate as provided by the user
     * @param years amortization period as provided by the user
     */
    public void onEstimateMortgage(float price, String downpayment, String rate, String years) {
        estimateMortgageInput.estimateMortgage(price, downpayment, rate, years);
    }

    /**
     * Displays the specified monthly payment to the user
     * @param monthly_payment payment to display
     */
    public void onEstimateMortgageSuccess(String monthly_payment) {
        this.viewInterface.displaySuccess("Your monthly mortgage is " + monthly_payment);
    }

    /**
     * Displays the reason that the program was unable to calculate mortgage
     * @param message String message to display to the user
     */
    public void onEstimateMortgageFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }
}
