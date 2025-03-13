package ParkingSlotSystem;

public class Ticket {
    int id;
    Slot slot;

    public Ticket(int id, Slot slot) {
        this.id = id;
        this.slot = slot;
    }

    public Slot getSlot() {
        return slot;
    }
}
