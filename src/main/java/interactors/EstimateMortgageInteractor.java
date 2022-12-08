package interactors;

import interactors.input_boundary.EstimateMortgageInput;
import interactors.output_boundary.EstimateMortgageOutput;

import java.text.DecimalFormat;


public class EstimateMortgageInteractor implements EstimateMortgageInput {

    EstimateMortgageOutput estimateMortgageOutput;

    public EstimateMortgageInteractor(EstimateMortgageOutput ob) {
        this.estimateMortgageOutput = ob;
    }

    /**
     * Estimates the mortgage and passes it off to the presenter
     * @param price the price obtained from the property object
     * @param downpayment user entered downpayment
     * @param rate user entered mortgage rate
     * @param years user entered amortization period
     */
    public void estimateMortgage(float price, String downpayment, String rate, String years) {
        DecimalFormat df = new DecimalFormat("#.##");

        double downpayment_double;
        double rate_double;
        int years_int;

        try {
            downpayment_double = Double.parseDouble(downpayment);
        } catch (Exception e) {
            this.estimateMortgageOutput.onEstimateMortgageFailure("Enter an integer or decimal amount for downpayment");
            return;
        } try {
            rate_double = Double.parseDouble(rate);
        } catch (Exception e) {
            this.estimateMortgageOutput.onEstimateMortgageFailure("Enter a decimal amount for rate.");
            return;
        } try {
            years_int = Integer.parseInt(years);
        } catch (Exception e) {
            this.estimateMortgageOutput.onEstimateMortgageFailure("Enter an integer amount for number of years.");
            return;
        }
        //estimate mortgage
        try {
            double principle = price - downpayment_double;
            rate_double = (rate_double/100)/12;
            int time = years_int * 12;
            double monthly_payment = (principle * rate_double) / (1 - Math.pow(1 + rate_double, -time));
            this.estimateMortgageOutput.onEstimateMortgageSuccess(df.format(monthly_payment));
        } catch (Exception e) {this.estimateMortgageOutput.onEstimateMortgageFailure("Failed to estimate");}


    }
}
