package FacadeDesignPattern;

public class HomeTheatreFacade {
    private final Amplifier amplifier;
    private final Projector projector;
    private final Lights lights;
    private final DVDPlayer dvdPlayer;

    HomeTheatreFacade(Amplifier amplifier, Projector projector, Lights lights, DVDPlayer dvdPlayer) {
        this.amplifier = amplifier;
        this.projector = projector;
        this.lights = lights;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("\nStarting Movie Mode...");
        lights.dim(30);
        amplifier.on();
        amplifier.setVolume(5);
        projector.on();
        projector.setInput(dvdPlayer);
        dvdPlayer.play(movie);
        System.out.println("Enjoy your movie!\n");
    }

    public void endMovie() {
        System.out.println("\nShutting Down Home Theatre...");
        dvdPlayer.off();
        projector.off();
        amplifier.off();
        lights.dim(100);
        System.out.println("Movie mode off.\n");
    }
}
