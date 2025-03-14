package ATM;

import ATM.ATMState.ATMState;
import ATM.ATMState.IdleState;

public class ATM {
    private Bank bank;
    private ATMState state;
    private Card card;
    double amountToWithDraw;
    double currentAmount;

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void insertCard(Card card) {
        state.insertCard(this, card);
    }

    public void authenticate(int pin) {
        state.authenticate(this, pin);
    }

    public void checkBalance() {
        state.checkBalance(this);
    }

    public ATM(Bank bank, double currentAmount) {
        this.bank = bank;
        this.state = new IdleState();
        amountToWithDraw = 0;
        card = null;
        this.currentAmount = currentAmount;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void setAmountToWithDraw(double amount) {
        amountToWithDraw = amount;
    }

    public Card getCard() {
        return card;
    }

    public double getBalance() {
        BankAccount account = bank.getAccount(card);
        return account.getBalance();
    }

    public void dispense() {
        BankAccount account = bank.getAccount(card);
        account.reduceBalance(amountToWithDraw);
        currentAmount -= amountToWithDraw;
        amountToWithDraw = 0;
        card = null;
        System.out.println("Here is you money");
        System.out.println("Remove your card");
    }
}
