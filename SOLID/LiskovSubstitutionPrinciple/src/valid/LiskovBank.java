package valid;

public class LiskovBank {
    public static void main(String[] args) {
        Withdrawable account1 = new SavingsAccount(1000);
        account1.withdraw(200); // Works fine ✅

        BankAccount account2 = new FixedDepositAccount(5000);
        // account2.withdraw(500); ❌ This is not allowed now, preventing runtime errors
        ((FixedDepositAccount) account2).earnInterest(); // Works fine ✅
    }
}