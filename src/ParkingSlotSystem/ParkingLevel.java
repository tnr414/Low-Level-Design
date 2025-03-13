package ParkingSlotSystem;

import java.util.List;

public class ParkingLevel {
    List<Slot> slots;

    public ParkingLevel(List<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
