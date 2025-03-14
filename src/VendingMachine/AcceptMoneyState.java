package VendingMachine;

public class AcceptMoneyState extends VendingMachineState{
    boolean acceptMoney(int money, Product product) {
        if (product.getPrice() <= money) {
            setAcceptedMoney(money);
            machine.setState(new DispenseProductState());
            return true;
        } else {
            System.out.println("Insufficient funds");
            machine.setState(new IdleState());
            return false;
        }

    }
}
