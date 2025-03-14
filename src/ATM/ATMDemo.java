package ATM;

public class ATMDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account = new BankAccount(12345, "Rahul");
        account.addBalance(10000.00);
        bank.addBankAccount(account);
        Card card = bank.issueATMCard(12345, 1234);
        ATM atm = new ATM(bank, 1000000.00);

        atm.insertCard(card);
        atm.authenticate(1234);
        atm.checkBalance();
    }
}
