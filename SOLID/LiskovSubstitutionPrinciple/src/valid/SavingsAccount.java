package valid;

class SavingsAccount extends BankAccount implements Withdrawable {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            throw new IllegalArgumentException("Insufficient balance!");
        }
    }
}