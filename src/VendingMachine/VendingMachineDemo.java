package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineDemo {
    public static List<Product> initProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new IceCream(20, 1));
        productList.add(new IceCream(35, 2));
        productList.add(new Chocolate(15, 3));
        productList.add(new Coke(50, 4));
        productList.add(new Coke(60, 5));
        return productList;
    }
    public static void main(String[] args) {

        List<Product> productList = initProduct();
        Inventory inventory = new Inventory(productList);
        VendingMachine machine = new VendingMachine();
        machine.setInventory(inventory);
        machine.display();
        Product selectedProduct = machine.selectProduct();
        System.out.println("Price of product is " + selectedProduct.getPrice() + " Enter money");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        machine.acceptMoney(money, selectedProduct);
        machine.dispenseProduct(selectedProduct);
        machine.returnMoney(selectedProduct);
    }
}
