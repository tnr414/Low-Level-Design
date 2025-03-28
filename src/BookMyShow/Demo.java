package BookMyShow;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Demo {
    static Theatre init() {
        Seat seat1 = new Seat(SeatType.NORMAL, 120.00, 1);
        Seat seat2 = new Seat(SeatType.NORMAL, 120.00, 2);
        Seat seat3 = new Seat(SeatType.PREMIUM, 180.00, 3);
        Seat seat4 = new Seat(SeatType.PREMIUM, 180.00, 4);

        Screen screen1 = new Screen(1);
        Screen screen2 = new Screen(2);
        screen1.addSeat(seat1);
        screen1.addSeat(seat2);

        screen2.addSeat(seat3);
        screen2.addSeat(seat4);

        Location location = new Location("Delhi");

        Theatre theatre = new Theatre(location, "ABC");
        Movie movie1 = new Movie("3idiots");
        Movie movie2 = new Movie("PK");
        Show show1 = new Show(1, movie1, screen1,
                new Date(15, Calendar.MARCH, 2025, 10, 10),
                new Date(15, Calendar.MARCH, 2025, 12, 40)
                );
        Show show2 = new Show(2, movie1, screen2,
                new Date(15, Calendar.MARCH, 2025, 18, 10),
                new Date(15, Calendar.MARCH, 2025, 20, 40)
        );

        Show show3 = new Show(3, movie2, screen1,
                new Date(15, Calendar.MARCH, 2025, 15, 15),
                new Date(15, Calendar.MARCH, 2025, 17, 40)
        );
        Show show4 = new Show(4, movie2, screen2,
                new Date(16, Calendar.MARCH, 2025, 13, 40),
                new Date(16, Calendar.MARCH, 2025, 15, 40)
        );
        theatre.addShow(show1);
        theatre.addShow(show2);
        theatre.addShow(show3);
        theatre.addShow(show4);

        return theatre;
    }
    public static void main(String[] args) {
        Theatre theatre = init();
        SystemManager systemManager = SystemManager.getInstance();
        systemManager.addTheatres(theatre);

        List<Show> shows = systemManager.getShowByLocation("Delhi");
        List<Seat> seats = systemManager.showSeatStatus(shows.getFirst());
        double price = systemManager.book(seats);
        systemManager.makePayment(price);
    }
}
