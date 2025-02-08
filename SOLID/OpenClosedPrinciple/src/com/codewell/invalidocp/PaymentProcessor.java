package com.codewell.invalidocp;

class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card payment of $" + amount);
        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment of $" + amount);
        } else if (paymentType.equals("UPI")) {
            System.out.println("Processing UPI payment of $" + amount);
        } else {
            throw new IllegalArgumentException("Unsupported payment method");
        }
    }
}
