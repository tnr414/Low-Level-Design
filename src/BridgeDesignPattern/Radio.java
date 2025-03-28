package BridgeDesignPattern;

public class Radio implements Device{
    private int volume = 50;
    @Override
    public void tunOn() {
        System.out.println("Radio is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned OFF");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("Radio volume set to " + percent + "%");
    }
}
