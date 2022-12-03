package Interactors;

import Entities.Properties.Property;

public class MortgageInteractor {

    /**
     * Simple mortgage estimator given equation M = P [ i(1 + i)^n ] / [ (1 + i)^n - 1]
     * Where
     * M = Total monthly payment
     * P = The total amount of your loan
     * I = Your interest rate, as a monthly percentage
     * N = The total amount of months in your timeline for paying off your mortgage
     *
     */
    public static double estimateMortgage(Property p, double downpayment, double rate, int months) {
        double loan = p.getPrice() - downpayment;
        double monthly_payment = loan * (Math.pow((rate * (1 + rate)), months)) / (Math.pow( (1+rate) , months) - 1);
        return monthly_payment;
    }
}
