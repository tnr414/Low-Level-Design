package VisitorDesignPattern;

public class Fruit implements ItemElement {
    private int weight;
    private int pricePerKg;
    private String name;

    public Fruit(int weight, int pricePerKg, String name) {
        this.weight = weight;
        this.pricePerKg = pricePerKg;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
