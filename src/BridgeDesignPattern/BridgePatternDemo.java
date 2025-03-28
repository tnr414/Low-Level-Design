package BridgeDesignPattern;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Device TV = new TV();
        RemoteControl tvRemote = new BasicRemote(TV);

        tvRemote.turnOn();
        tvRemote.setVolume(70);
        ((BasicRemote)tvRemote).mute();
        tvRemote.turnOff();

        System.out.println();

        Device Radio = new Radio();
        RemoteControl radioRemote = new BasicRemote(Radio);

        radioRemote.turnOn();
        radioRemote.setVolume(40);
        ((BasicRemote)radioRemote).mute();
        radioRemote.turnOff();
    }
}
