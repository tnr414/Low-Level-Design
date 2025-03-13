package ParkingSlotSystem;

public class User {
    String name;
    Ticket ticket;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
