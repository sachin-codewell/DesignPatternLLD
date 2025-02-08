package com.codewell.validocp;

public class ProcessPayment {
    public void process(PaymentStrategy paymethod,double amount){
        paymethod.processPayment(amount);
    }

}
