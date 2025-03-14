package ATM.ATMState;

import ATM.*;

public class CashWithdrawState implements ATMState{
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
        System.out.println("Cant' check balance now");
    }

    @Override
    public boolean cashWithdraw(ATM atm, double amount) {
        double balance = atm.getBalance();
        double atmBalance = atm.getCurrentAmount();
        if (balance < amount || atmBalance < amount ) {
            System.out.println("Insufficient Fund");
            atm.setState(new IdleState());
            return false;
        } else {
            atm.setAmountToWithDraw(amount);
            atm.setState(new DispenseState());
            return false;
        }
    }

    @Override
    public void dispense(ATM atm) {
        System.out.println("Can't dispense now");
    }
}