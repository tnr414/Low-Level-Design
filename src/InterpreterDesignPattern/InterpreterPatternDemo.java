package InterpreterDesignPattern;

public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // Represents: (10 + 5) - 3
        Expression expression = new SubtractionExpression(new AdditionExpression(
                new NumberExpression(10), new NumberExpression(5)),
                new NumberExpression(3)
        );

        System.out.println("Result: " + expression.interpret());
    }
}
