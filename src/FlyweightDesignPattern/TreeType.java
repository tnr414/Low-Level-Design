package FlyweightDesignPattern;

public class TreeType implements Tree{
    private final String type;  // Intrinsic state
    private final String color;  // Intrinsic state
    private final String texture;  // Intrinsic state

    TreeType(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void render(int x, int y) {
        System.out.println("Rendering " + type + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}
