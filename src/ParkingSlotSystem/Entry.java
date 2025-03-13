package ParkingSlotSystem;

public class Entry {
    public static int ticketId = 0;
    int entryNo;
    ParkingSlotManager parkingSlotManager;

    public Entry(int entryNo, ParkingSlotManager parkingSlotManager) {
        this.entryNo = entryNo;
        this.parkingSlotManager = parkingSlotManager;
    }

     public void enter(Vehicle vehicle, User user) {
       Slot slot = parkingSlotManager.bookSlot(vehicle);
        if (slot != null) {
            Ticket ticket = new Ticket(++ticketId, slot);
            user.setTicket(ticket);
            System.out.println("Booked slot with id " + slot.getId() + " for  " + user.getName() + " for vehicle number " + vehicle.getId());
        } else {
            System.out.println("All slots are current booked");
        }
    }
}
