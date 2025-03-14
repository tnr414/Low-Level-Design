package VendingMachine;

public class DispenseProductState extends VendingMachineState {

    @Override
    boolean dispenseProduct(Product product) {
        inventory.removeProduct(product);
        System.out.println("Dispensed product with product id " + product.getId());
        machine.setState(new ReturnMoneyState());
        return true;
    }
}
