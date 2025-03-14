package CarRentalSystem;

import java.util.List;

public class Store {
    private List<Vehicle> vehicles;

    public Store(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


}
