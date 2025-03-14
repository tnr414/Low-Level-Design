package VendingMachine;

abstract public class VendingMachineState {
    protected Inventory inventory;
    protected int acceptedMoney = 0;
    protected VendingMachine machine;


    public void setAcceptedMoney(int acceptedMoney) {
        this.acceptedMoney = acceptedMoney;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    void display() {
        System.out.println("Oops! can't show now");
    }

    Product selectProduct() {
        System.out.println("Can't select product now");
        return null;
    }

    boolean acceptMoney(int money, Product product) {
        System.out.println("Can't accept money now");
        return false;
    }

    boolean dispenseProduct(Product product) {
        System.out.println("Can't dispense now");
        return false;
    }

    int returnMoney(Product product) {
        System.out.println("Can't return money now");
        return 0;
    }
}
