package com.codewell.validocp;

import javax.swing.*;

public class Main {
    public static void main(String args []) {
        ProcessPayment processPayment = new ProcessPayment();
        processPayment.process(new CreditCard(),300);
        processPayment.process(new UPI(), 123);
    }
}
