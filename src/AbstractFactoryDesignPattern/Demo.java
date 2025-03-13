package AbstractFactoryDesignPattern;

public class Demo {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory factory = GUIFactory.getFactory(osName);
        System.out.println("Current os is " + osName);
        if(factory != null) {
            Applicataion applicataion = new Applicataion(factory);
            applicataion.renderUI();
        } else {
            System.out.println("oops can't render for this os");
        }
    }
}
