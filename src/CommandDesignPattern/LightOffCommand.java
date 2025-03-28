package CommandDesignPattern;

public class LightOffCommand implements Command{
    private final Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
