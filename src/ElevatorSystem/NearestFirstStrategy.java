package ElevatorSystem;

import java.util.List;

public class NearestFirstStrategy implements ElevatorSystemStrategy{
    @Override
    public int nextDestination(Elevator elevator) {
        // will improve this logic
        return elevator.getDestination().poll();
    }

    @Override
    public Elevator findElevator(List<Elevator> elevators, int floorNumber) {
        int currDistance = ElevatorSystem.totalFloor * 2 + 1;
        Elevator result = null;
        for (Elevator elevator: elevators) {
            if (elevator.getLoad() != elevator.getLimit()) {
                if (floorNumber == elevator.getCurrentFloor()) return elevator;
                if (elevator.getCurrentFloor() < floorNumber) {
                    if (elevator.getCurrentStatus() == ElevatorStatus.IDLE
                            || elevator.getCurrentDir() == Direction.UP) {
                        int distance = floorNumber - elevator.getCurrentFloor();
                        if (currDistance > distance) {
                            result = elevator;
                            distance = currDistance;
                        }
                    } else {
                        int distance = floorNumber + elevator.getCurrentFloor();
                        if (currDistance > distance) {
                            result = elevator;
                            distance = currDistance;
                        }
                    }
                } else {
                    if (elevator.getCurrentStatus() == ElevatorStatus.IDLE
                            || elevator.getCurrentDir() == Direction.DOWN) {
                        int distance = elevator.getCurrentFloor() - floorNumber;
                        if (currDistance > distance) {
                            result = elevator;
                            distance = currDistance;
                        }
                    } else {
                        int distance = (ElevatorSystem.totalFloor - floorNumber) + (ElevatorSystem.totalFloor - elevator.getCurrentFloor());
                        if (currDistance > distance) {
                            result = elevator;
                            distance = currDistance;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean requestDestination(Elevator elevator, int floorNumber) {
        elevator.getDestination().offer(floorNumber);
        return true;
    }
}
