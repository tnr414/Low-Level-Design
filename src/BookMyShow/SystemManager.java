package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {
    private List<Theatre> theatres;
    private Payment payment;
    private static SystemManager instance;

    private SystemManager() {
        theatres = new ArrayList<Theatre>();
        payment = new Payment();
    }

    public void addTheatres(Theatre theatre) {
        theatres.add(theatre);
    }

    synchronized public static SystemManager getInstance() {
        if (instance == null) {
            instance = new SystemManager();
        }
        return instance;
    }

    public List<Show> getShowByLocation(String city) {
        List<Show> shows = new ArrayList<>();

        for (Theatre theatre: theatres) {
            System.out.println(theatre.getLocation().getCity() + " " + city);
            System.out.println(theatre.getLocation().getCity().equals(city));
            if (theatre.getLocation().getCity().equals(city)) {
                shows.addAll(theatre.getShowList());
                theatre.displayShow();
            }
        }
        return shows;
    }

    public List<Seat> showSeatStatus(Show show) {
        List<Seat> seats = new ArrayList<>();
        for (Seat seat: show.getScreen().getSeatList()) {
            if (seat.getStatus() != SeatStatus.BOOKED)  {
                seats.add(seat);
            }
            System.out.println(seat.getSeatNumber() + ": " + ((seat.getStatus() == SeatStatus.BOOKED) ? "Booked" : "Empty"));
        }
        return seats;
    }

    synchronized public double book(List<Seat> seats) {
        double totalPrice = 0;
        for (Seat seat: seats) {
            totalPrice += seat.getPricing();
            seat.setStatus(SeatStatus.BOOKED);
        }
        System.out.println("Pay " + totalPrice);
        return totalPrice;
    }

    void makePayment(double amount) {
        payment.makePayment(amount);
    }
}
