package AdapterDesignPattern;

public class VoltageAdapter implements MobileCharger{
    private  final Voltage220v voltage220v;

    VoltageAdapter(Voltage220v voltage220v) {
        this.voltage220v = voltage220v;
    }

    @Override
    public int get5v() {
       return convertTo5v(voltage220v.get220v());
    }

    private int convertTo5v(int voltage) {
        return  voltage / 44;
    }
}
