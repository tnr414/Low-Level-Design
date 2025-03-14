package CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSystem {
    Store store;
    BookingManagement bookingManagement;

    public SearchSystem(Store store, BookingManagement bookingManagement) {
        this.store = store;
        this.bookingManagement = bookingManagement;
    }

    List<Vehicle> searchByType(VehicleType type) {
        return store.getVehicles().stream()
                .filter(v -> v.getType() == type)
                .toList();
    }

    List<Vehicle> searchByPriceRange(double start, double end) {
        return store.getVehicles().stream()
                .filter(v -> v.getPrice() <= end && v.getPrice() >= start)
                .toList();
    }

    List<Vehicle> searchByAvailability(Date startDate, Date endDate) {
        List<Vehicle> vehicles = store.getVehicles();
        List<Booking> bookings = bookingManagement.getBookings();
        List<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle: vehicles) {
            boolean found = false;
            for (Booking booking: bookings) {
                System.out.println(booking.getVehicle().equals(vehicle));
                if (booking.getVehicle().equals(vehicle) &&
                        ((booking.getEndDate().after(startDate) && booking.getStartDate().before(startDate))
                        || (booking.getEndDate().before(endDate) && booking.getEndDate().after(startDate)))
                ) {
                    System.out.println("booking found for " + vehicle.getModel() + " " + booking.getId());
                    found = true;
                }
            }
            if (!found) {
                result.add(vehicle);
            }
        }

        return result;
    }
}
