package ElevatorSystem;

import java.util.List;

public interface ElevatorSystemStrategy {
    int nextDestination(Elevator elevator);
    Elevator findElevator(List<Elevator> elevators, int floorNumber);
    boolean requestDestination(Elevator elevator, int floorNumber);
}
