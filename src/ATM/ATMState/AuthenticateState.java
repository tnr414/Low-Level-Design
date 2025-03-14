package ATM.ATMState;

import ATM.*;

import java.util.Scanner;

public class AuthenticateState implements ATMState{
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Can't insert card now");
    }

    @Override
    public boolean authenticate(ATM atm, int pin) {
        if(atm.getCard().authenticate(pin)) {
            System.out.println("Enter 1 to check balance and 2 to withdraw");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option == 1) {
                atm.setState(new CheckBalanceState());
            } else if (option == 2) {
                atm.setState(new CashWithdrawState());
            } else {
                System.out.println("Invalid option");
                atm.setState(new IdleState());
            }
            return true;
        } else {
            System.out.println("Incorrect pin");
            atm.setState(new IdleState());
            return false;
        }
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