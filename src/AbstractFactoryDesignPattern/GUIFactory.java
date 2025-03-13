package AbstractFactoryDesignPattern;

import FactoryDesignPattern.Circle;
import FactoryDesignPattern.Rectangle;

abstract public class GUIFactory {

        public  static  GUIFactory getFactory(String osName) {
        return switch (osName) {
            case "windows" -> new WindowsFactory();
            case "mac os x" -> new MacFactory();
            default -> null;
        };
    }
    abstract Button getButton();
    abstract CheckBox getCheckbox();
}
