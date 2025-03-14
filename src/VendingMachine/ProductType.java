package VendingMachine;

public enum ProductType {
    COKE("Cock"),
    ICE_CREAM("Icecream"),
    CHOCOLATE("Chocolate");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}