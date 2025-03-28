package FacadeDesignPattern;

public class Amplifier {
    void on() {
        System.out.println("Amplifier is ON");
    }
    void off() {
        System.out.println("Amplifier is OFF");
    }
    void setVolume(int volume) {
        System.out.println("Amplifier volume set to " + volume);
    }
}
