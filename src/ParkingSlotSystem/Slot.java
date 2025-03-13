package ParkingSlotSystem;

public class Slot {
    int id;
    VehicleType vehicleType;
    BookingStatus status;

    public Slot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        status = BookingStatus.EMPTY;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
