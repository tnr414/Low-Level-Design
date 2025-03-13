package FactoryDesignPattern;

public class ShapeFactory {

    public Shape getShape(String shapeName) {
        return switch (shapeName) {
            case "Circle" -> new Circle();
            case "Rectangle" -> new Rectangle();
            default -> null;
        };
    }
}
