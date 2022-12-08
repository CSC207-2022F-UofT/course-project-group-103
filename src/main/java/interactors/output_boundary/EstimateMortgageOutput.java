package interactors.output_boundary;

public interface EstimateMortgageOutput {

    void onEstimateMortgageSuccess(String monthly_payment);

    void onEstimateMortgageFailure(String message);
}
