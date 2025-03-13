package AbstractFactoryDesignPattern;

public class MacFactory extends GUIFactory{
    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public CheckBox getCheckbox() {
        return new MacCheckbox();
    }
}
