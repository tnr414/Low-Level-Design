package BridgeDesignPattern;

abstract public class RemoteControl {
    protected Device device;
    RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.tunOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void setVolume(int percent) {
        device.setVolume(percent);
    }
}
