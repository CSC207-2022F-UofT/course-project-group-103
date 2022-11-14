package Interactors;

import Properties.Property;

public class MortgageInteractor {

    public static double estimateMortgage(Property p, double downpayment, double rate, int months) {
        double loan = p.getPrice() - downpayment;
        double monthly_payment = loan * (Math.pow((rate * (1 + rate)), months)) / (Math.pow( (1+rate) , months) - 1);
        return monthly_payment;
    }
}
