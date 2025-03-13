package FactoryDesignPattern;

import java.util.Scanner;

public class FactoryDesignPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        System.out.println("Choose a shape");
        Scanner sc = new Scanner(System.in);
        String shapeName = sc.next();
        Shape shape = shapeFactory.getShape(shapeName);
        if (shape == null) {
            System.out.println("Selected shape is not available");
        } else {
            shape.draw();
        }
    }
}
