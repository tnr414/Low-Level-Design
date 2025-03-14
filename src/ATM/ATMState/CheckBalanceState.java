package ATM.ATMState;

import ATM.*;

public class CheckBalanceState implements ATMState{
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Can't insert card now");
    }

    @Override
    public boolean authenticate(ATM atm, int pin) {
        System.out.println("Can't authenticate now");
        return false;
    }

    @Override
    public void checkBalance(ATM atm) {
        double amount = atm.getBalance();
        System.out.println("Current balance is " + amount);
        atm.setState(new IdleState());
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