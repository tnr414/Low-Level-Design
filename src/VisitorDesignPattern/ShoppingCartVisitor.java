package VisitorDesignPattern;

public class ShoppingCartVisitor implements Visitor {
    @Override
    public void visit(Book book) {
        int cost = book.getPrice();
        System.out.println("Book: " + book.getName() + ", Cost = " + cost);
    }

    @Override
    public void visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println("Fruit: " + fruit.getName() + ", Cost = " + cost);
    }
}
