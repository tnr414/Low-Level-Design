package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    public static int totalFloor = 8;
    ElevatorSystemStrategy elevatorSystemStrategy = new NearestFirstStrategy();
    List<Elevator> elevatorList;
    private static ElevatorSystem instance;
    private ElevatorSystem() {
        // nothing here
        elevatorList = init();
    }

    synchronized public static ElevatorSystem getInstance() {
        if (instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }

    private List<Elevator> init() {
        List<Elevator> elevators = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            elevators.add(new Elevator(10, i + 1));
        }
        return elevators;
    }

    public Elevator requestElevator(int floorNumber) {
        return elevatorSystemStrategy.findElevator(elevatorList, floorNumber);
    }

    public void requestDestination(Elevator elevator, int floorNumber) {
        elevatorSystemStrategy.requestDestination(elevator, floorNumber);
        System.out.println("Request accepted");
    }
}
