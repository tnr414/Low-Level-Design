package FlyweightDesignPattern;

public class FlyweightPatternDemo {
    public static void main(String[] args) {
        Forest forest = new Forest();

        forest.plantTree(1, 2, "Oak", "Green", "Rough");
        forest.plantTree(3, 5, "Pine", "Dark Green", "Smooth");
        forest.plantTree(5, 8, "Oak", "Green", "Rough");  // Uses the shared Oak object
        forest.plantTree(7, 10, "Pine", "Dark Green", "Smooth");  // Uses the shared Pine object
        forest.plantTree(9, 12, "Oak", "Green", "Rough");  // Uses the shared Oak object

        // Render the forest
        forest.renderForest();
    }
}
