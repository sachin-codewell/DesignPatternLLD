package com.codewell.invalidocp;

public class Main {
    public static void main(String args[]) {
        PaymentProcessor paymentgateway = new PaymentProcessor();
        paymentgateway.processPayment("CREDIT_CARD",2550.67);
    }
}


