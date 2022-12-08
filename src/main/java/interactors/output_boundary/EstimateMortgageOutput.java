package interactors.output_boundary;

public interface EstimateMortgageOutput {

    void onEstimateMortgageSuccess(double monthly_payment);

    void onEstimateMortgageFailure(String message);
}
