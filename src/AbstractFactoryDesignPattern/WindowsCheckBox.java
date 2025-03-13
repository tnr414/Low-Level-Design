package AbstractFactoryDesignPattern;

public class WindowsCheckBox implements CheckBox{
    @Override
    public void render() {
        System.out.println("Rendering Windows checkbox");
    }
}
