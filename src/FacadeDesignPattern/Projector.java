package FacadeDesignPattern;

public class Projector {
    void on() {
        System.out.println("Projector is ON");
    }
    void off() {
        System.out.println("Projector is OFF");
    }
    void setInput(DVDPlayer dvd) {
        System.out.println("Projector input set to DVD player");
    }
}
