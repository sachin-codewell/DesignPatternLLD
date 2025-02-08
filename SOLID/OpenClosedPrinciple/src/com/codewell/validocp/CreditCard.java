package com.codewell.validocp;

public class CreditCard implements PaymentStrategy{

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Done using Credit card, "+"Bill "+ amount+ " $");
    }
}
