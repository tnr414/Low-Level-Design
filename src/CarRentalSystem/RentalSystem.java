package CarRentalSystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RentalSystem {
    public static List<Vehicle> init() {
        return  new ArrayList<>(List.of(
            new Vehicle("Swift", VehicleType.TYPE1, 1000.00f, 3456),
            new Vehicle("Desire", VehicleType.TYPE1, 1050.00f, 2524),
            new Vehicle("BMW", VehicleType.TYPE2, 3500.00f, 5755),
            new Vehicle("Fortuner", VehicleType.TYPE2, 1800.00f, 3566)
        ));
    }
    public static void main(String[] args) {
        Store store = new Store(init());
        BookingManagement bookingManagement = new BookingManagement();
        SearchSystem searchSystem = new SearchSystem(store, bookingManagement);

        for (Vehicle v: searchSystem.searchByPriceRange(900.00, 1500.00)) {
            System.out.println(v.getModel() + " price: " + v.getPrice());
        }

        User user1 = new User("ABC", 384363376, "sfhuhf");

        for (Vehicle v: searchSystem.searchByType(VehicleType.TYPE2)) {
            System.out.println(v.getModel() + " price: " + v.getPrice());
            Booking booking = new Booking(1, v, user1, new Date(2025, Calendar.MARCH, 16), new Date(2025, Calendar.MARCH, 18));
            bookingManagement.addBooking(booking);
        }

        for (Vehicle v: searchSystem.searchByAvailability(new Date(2025, Calendar.MARCH, 17), new Date(2025, Calendar.MARCH, 19))) {
            System.out.println(v.getModel() + " price: " + v.getPrice());
        }
    }
}
