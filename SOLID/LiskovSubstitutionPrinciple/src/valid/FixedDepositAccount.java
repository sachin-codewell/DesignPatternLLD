package valid;

class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(double balance) {
        super(balance);
    }

    public void earnInterest() {
        System.out.println("Interest added to Fixed Deposit Account.");
    }
}