package ATM;

public class BankAccount {
    private final int accountNumber;
    private double balance;
    private final String accountHolder;

    public BankAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0f;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void reduceBalance(double balance) {
        this.balance -= balance;
    }
}
