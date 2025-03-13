package ParkingSlotSystem;

public class Exit {
    int exitNo;
    ParkingSlotManager parkingSlotManager;


    public Exit(int exitNo, ParkingSlotManager parkingSlotManager) {
        this.exitNo = exitNo;
        this.parkingSlotManager = parkingSlotManager;
    }

    public boolean exit(Vehicle vehicle, User user) {
        Ticket ticket = user.getTicket();
        Slot slot = ticket.getSlot();
        boolean exitStatus  = parkingSlotManager.vacateSlot(slot);
        if (exitStatus) {
            System.out.println("Exit successfull with slot id " + slot.getId() +  " for " + user.getName() + " vehicle number " + vehicle.getId());
            return true;
        } else {
            System.out.println("Invalid ticket");
            return false;
        }
    }
}
