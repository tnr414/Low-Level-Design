package ATM.ATMState;

import ATM.*;

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATM atm, Card card) {
        atm.setCard(card);
        atm.setState(new AuthenticateState());
        System.out.println("Card inserted successfully");
    }

    @Override
    public boolean authenticate(ATM atm, int pin) {
        System.out.println("Can't authenticate now");
        return false;
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Cant' check balance now");
    }

    @Override
    public boolean cashWithdraw(ATM atm, double amount) {
        System.out.println("Can't withdraw money now");
        return false;
    }

    @Override
    public void dispense(ATM atm) {
        System.out.println("Can't dispense now");
    }
}
