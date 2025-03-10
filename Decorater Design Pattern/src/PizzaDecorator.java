abstract public class PizzaDecorator extends Pizza {
    Pizza pizza;
    public PizzaDecorator(int extraPrice, Pizza pizza) {
        super(pizza.getPrice() + extraPrice);
        this.pizza = pizza;
    }
}
