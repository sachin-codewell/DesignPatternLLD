package com.codewell.validocp;

public class UPI implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Done using UPI, "+"Bill "+ amount+ " $");
    }
}
