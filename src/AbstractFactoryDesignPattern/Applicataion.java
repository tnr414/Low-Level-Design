package AbstractFactoryDesignPattern;

public class Applicataion {
    Button button;
    CheckBox checkBox;
    public Applicataion(GUIFactory factory) {
        button = factory.getButton();
        checkBox = factory.getCheckbox();
    }

    public void renderUI() {
        button.render();
        checkBox.render();
    }
}
