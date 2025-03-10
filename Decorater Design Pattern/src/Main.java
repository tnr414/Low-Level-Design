//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pizza margheritaPizza = new MargheritaPizza();
        Pizza pepperoniPizza = new PepperoniPizza();
        Pizza margheritaPizzaWithMushroom = new MushroomPizzaDecorator(margheritaPizza);
        Pizza margheritaPizzaWithMushroomAndCheese = new CheesePizzaDecorator(margheritaPizzaWithMushroom);
        Pizza pepperoniPizzaWithCheese = new CheesePizzaDecorator(pepperoniPizza);
        Pizza pepperoniPizzaWithCheeseAndMushroom = new MushroomPizzaDecorator(pepperoniPizzaWithCheese);


        System.out.println("Price of Margherita Pizza: " + margheritaPizza.getPrice());
        System.out.println("Price of Pepperoni Pizza: " + pepperoniPizza.getPrice());
        System.out.println("Price of Margherita Pizza with mushroom: " + margheritaPizzaWithMushroom.getPrice());
        System.out.println("Price of Pepperoni Pizza with cheese: " + pepperoniPizzaWithCheese.getPrice());
        System.out.println("Price of Margherita Pizza with mushroom and cheese: " + margheritaPizzaWithMushroomAndCheese.getPrice());
        System.out.println("Price of Pepperoni Pizza with cheese and mushroom: " + pepperoniPizzaWithCheeseAndMushroom.getPrice());
    }
}