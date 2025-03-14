package VendingMachine;

public class VendingMachine {
    VendingMachineState currentState;
    VendingMachine() {
        currentState = new IdleState(this);
    }

    void setInventory(Inventory inventory) {
        currentState.setInventory(inventory);
    }

    void setState(VendingMachineState state) {
        currentState = state;
    }

    void display() {
        currentState.display();
    }

    Product selectProduct() {
        return currentState.selectProduct();
    }

    boolean acceptMoney(int money, Product product) {
        return currentState.acceptMoney(money, product);
    }

    boolean dispenseProduct(Product product) {
        return currentState.dispenseProduct(product);
    }

    int returnMoney(Product product) {
        return currentState.returnMoney(product);
    }


}
