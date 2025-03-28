package VisitorDesignPattern;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(new Book(500, "Design Patterns"));
        shoppingCart.addItem(new Fruit(2, 100, "Apple"));

        Visitor visitor = new ShoppingCartVisitor();
        shoppingCart.checkout(visitor);
    }
}
