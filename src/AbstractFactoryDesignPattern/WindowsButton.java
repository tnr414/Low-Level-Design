package AbstractFactoryDesignPattern;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering windows button");
    }
}
