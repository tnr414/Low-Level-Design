package BridgeDesignPattern;

public class TV implements Device{
    private int volume = 30;

    @Override
    public void tunOn() {
        System.out.println("TV is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned OFF");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("TV volume set to " + percent + "%");
    }
}
