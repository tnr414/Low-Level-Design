package VisitorDesignPattern;

public class Book implements ItemElement {
    private int price;
    private String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
