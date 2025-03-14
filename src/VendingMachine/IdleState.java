package VendingMachine;

import java.util.List;

public class IdleState extends VendingMachineState{
    IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    IdleState() {

    }

    @Override
    void display() {
        List<Product> products = inventory.getProducts();
        for (Product product: products) {
            System.out.println("Product id: " + product.getId() + " type: " + product.getType().getName() + " price: " + product.getPrice());
        }
        machine.setState(new SelectProduct());
    }
}
