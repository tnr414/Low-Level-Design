package AdapterDesignPattern;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        Voltage220v voltage220v = new Voltage220v();
        MobileCharger charger = new VoltageAdapter(voltage220v);
        System.out.println("Mobile charger output: " + charger.get5v() + " V");
    }
}
