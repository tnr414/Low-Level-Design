package FacadeDesignPattern;

public class DVDPlayer {
    void on() {
        System.out.println("Player is ON");
    };
    void off() {
        System.out.println("Player is OFF");
    };
    void play(String movie) {
        System.out.println("Playing movie " + movie);
    };
}
