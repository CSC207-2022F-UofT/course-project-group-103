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

    public void onEstimateMortgage(float price, String downpayment, String rate, String years) {
        estimateMortgageInput.estimateMortgage(price, downpayment, rate, years);
    }


    public void onEstimateMortgageSuccess(double monthly_payment) {
        this.viewInterface.displaySuccess("Your monthly mortgage is " + monthly_payment);

    }

    public void onEstimateMortgageFailure(String message) {
        this.viewInterface.displayFailure(message);
    }

    public void onBack() {
        this.viewInterface.displayPrevious();
    }
}
