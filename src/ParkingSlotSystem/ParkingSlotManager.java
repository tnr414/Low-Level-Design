package ParkingSlotSystem;

import java.util.List;

public class ParkingSlotManager {
    ParkingArea parkingArea;

    public ParkingSlotManager(ParkingArea parkingArea) {
        this.parkingArea = parkingArea;
    }

    public Slot bookSlot(Vehicle vehicle) {
        Slot slot = findSlot(vehicle.getVehicleType());
        if (slot == null) return null;

        if (slot.getStatus() != BookingStatus.BOOKED) {
            // for handling concurrency
            synchronized (slot) {
                slot.setStatus(BookingStatus.BOOKED);
            }
            return slot;
        } else  {
            System.out.println("This slot is already booked, choose some other slot");
            return  null;
        }
    }

    public boolean vacateSlot(Slot slot) {
        if (slot.getStatus() != BookingStatus.EMPTY) {
            slot.setStatus(BookingStatus.EMPTY);
            return true;
        } else  {
            System.out.println("This slot is already empty!");
            return  false;
        }
    }

    private Slot findSlot(VehicleType type) {
        List<ParkingLevel> levels = parkingArea.getLevels();
        for (ParkingLevel level: levels) {
            List<Slot> slots = level.getSlots();
            for (Slot slot: slots) {
                if (slot.getStatus() == BookingStatus.EMPTY && type == slot.vehicleType) {
                    return  slot;
                }
            }
        }
        return null;
    }
}
