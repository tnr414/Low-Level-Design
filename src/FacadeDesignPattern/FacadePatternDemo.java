package FacadeDesignPattern;

public class FacadePatternDemo {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();
        Lights lights = new Lights();

        HomeTheatreFacade homeTheatre = new HomeTheatreFacade(amplifier, projector, lights, dvdPlayer);

        homeTheatre.watchMovie("Inception");
        homeTheatre.endMovie();
    }
}
