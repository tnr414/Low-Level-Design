package AbstractFactoryDesignPattern;

public class WindowsFactory extends GUIFactory{
    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox getCheckbox() {
        return new WindowsCheckBox();
    }
}
