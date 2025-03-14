package ATM;

public class Card {
    private long cardNumber;
    private BankAccount bankAccount;
    private int pin;

    public Card(long cardNumber, BankAccount bankAccount, int pin) {
        this.cardNumber = cardNumber;
        this.bankAccount = bankAccount;
        this.pin = pin;
    }

    public boolean authenticate(int pin) {
        return this.pin == pin;
    }

    public long getCardNumber() {
        return cardNumber;
    }
}
