package invalid;

class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawals are not allowed for Fixed Deposit accounts!");
    }
}