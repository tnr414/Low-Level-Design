package ATM.ATMState;

import ATM.ATM;
import ATM.Card;

public interface ATMState {
    void insertCard(ATM atm, Card card);
    boolean authenticate(ATM atm, int pin);
    void checkBalance(ATM atm);
    boolean cashWithdraw(ATM atm, double amount);
    void dispense(ATM atm);
}
