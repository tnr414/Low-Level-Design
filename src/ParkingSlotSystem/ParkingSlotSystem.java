package ParkingSlotSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotSystem {
    private static List<ParkingLevel>  initParkingLevels() {
        List<ParkingLevel> levels = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Slot> slots = new ArrayList<>();
            Slot slo1 = new Slot(3*i+1, VehicleType.BIKE);
            Slot slo2 = new Slot(3*i+2, VehicleType.CAR);
            Slot slo3 = new Slot(3*i+3, VehicleType.BUS);
            slots.add(slo1);
            slots.add(slo2);
            slots.add(slo3);
            ParkingLevel level = new ParkingLevel(slots);
            levels.add(level);
        }
        return levels;
    }

    public static void main(String[] args) {
        List<ParkingLevel> levels = initParkingLevels();
        ParkingArea area = new ParkingArea(levels);
        ParkingSlotManager parkingSlotManager = new ParkingSlotManager(area);
        Entry entry1 = new Entry(1, parkingSlotManager);
        Entry entry2 = new Entry(2, parkingSlotManager);

        Exit exit1 = new Exit(1, parkingSlotManager);
        Exit exit2 = new Exit(2, parkingSlotManager);

        User rahul = new User("Rahul");
        User raj = new User("Raj");

        Car car1 = new Car(1234, "Swift");
        entry2.enter(car1, rahul);
        Bike bike1 = new Bike(4567, "Apache");
        entry1.enter(bike1, raj);

        exit2.exit(bike1, raj);
        exit1.exit(car1, rahul);
    }
}
