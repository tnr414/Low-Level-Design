package BuilderDesignPattern;

public class Computer {
    private final String cpu; // required
    private final String ram; // required
    private final String storage; // optional
    private final String graphicsCard; // optional
    private final String coolingSystem; // optional
    private final String os; // optional

    public Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.coolingSystem = builder.coolingSystem;
        this.os = builder.os;
    }

    @Override
    public String toString() {
        return "Computer{"+
                "CPU='" + cpu + '\''+
                ", RAM='" + ram + '\''+
                ", Storage='" + storage + '\''+
                ", Graphics Card='" + graphicsCard + '\''+
                ", Cooling System='" + coolingSystem + '\''+
                ", OS ='" + os + '\''+
                "}";
    }
}
