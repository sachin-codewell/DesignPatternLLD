package invalid;

public class LiskovViolationBank {
    public static void main(String[] args) {
        BankAccount account1 = new SavingsAccount(1000);
        account1.withdraw(200); // Works fine ✅

        BankAccount account2 = new FixedDepositAccount(5000);
        account2.withdraw(500); // Throws exception ❌ (Unexpected behavior)
    }
}

/*
BankAccount assumes all accounts can withdraw money, but FixedDepositAccount breaks that expectation.
If we substitute FixedDepositAccount for BankAccount, the program fails unexpectedly.
Clients expecting withdrawal functionality get an exception, breaking their assumptions.
 */