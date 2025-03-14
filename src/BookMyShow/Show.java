package BookMyShow;

import java.util.Date;

public class Show {
    private final int id;
    private final Movie movie;
    private final Screen screen;
    private final Date startTime;
    private final Date endTime;

    public Show(int id, Movie movie, Screen screen, Date startTime, Date endTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
