package VendingMachine;

import java.util.Scanner;

public class SelectProduct extends VendingMachineState {
    @Override
    Product selectProduct(){
        Scanner sc = new Scanner(System.in);
        int productId = sc.nextInt();
        Product product = this.inventory.getProduct(productId);
        machine.setState(new AcceptMoneyState());
        return product;
    }

}
