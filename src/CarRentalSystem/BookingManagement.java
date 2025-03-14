package CarRentalSystem;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingManagement {
    List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booked " + booking.getVehicle().getModel());
    }

    public void cancelBooking(Booking booking) {
        bookings = bookings.stream().filter(b -> b.getId() != booking.getId()).collect(Collectors.toList());
    }

    public void updateBooking(Booking booking, int bookingId) {
        Optional<Booking> oldBooking = bookings.stream().filter(b -> b.getId() == bookingId).findFirst();
        if (oldBooking.isPresent()) {
            oldBooking.ifPresent(booking1 -> {
                booking1.setStartDate(booking.getStartDate());
                booking1.setEndDate(booking.getEndDate());
                booking1.setVehicle(booking.getVehicle());
                booking1.setUser(booking.getUser());
            });
        } else {
            System.out.println("Booking Not found");
        }
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
