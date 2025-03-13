package ParkingSlotSystem;

public class Vehicle {
    private int id;
    private String brand;
    private VehicleType vehicleType;

    public Vehicle(int id, String brand, VehicleType vehicleType) {
        this.id = id;
        this.brand = brand;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
