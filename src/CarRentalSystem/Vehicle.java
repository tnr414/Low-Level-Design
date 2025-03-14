package CarRentalSystem;

public class Vehicle {
    String model;
    VehicleType type;
    double price;
    int platNumber;

    public Vehicle(String model, VehicleType type, double price, int platNumber) {
        this.model = model;
        this.type = type;
        this.price = price;
        this.platNumber = platNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
