package VendingMachine;

public class ReturnMoneyState extends VendingMachineState{
    @Override
    int returnMoney(Product product) {
        int remainingAmount = acceptedMoney - product.getPrice();
        System.out.println("Returning amount " + remainingAmount);
        machine.setState(new IdleState());
        return remainingAmount;
    }
}
