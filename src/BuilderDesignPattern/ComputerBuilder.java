package BuilderDesignPattern;

public class ComputerBuilder {
    protected final String cpu; // required
    protected final String ram; // required
    protected String storage; // optional
    protected String graphicsCard; // optional
    protected String coolingSystem; // optional
    protected String os; // optional

    ComputerBuilder(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerBuilder setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    public ComputerBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}
