package ElevatorSystem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Elevator {
    int elevatorNo;
    private int limit;
    private ElevatorStatus currentStatus;
    private Integer currentFloor;
    private Direction currentDir;
    private PriorityQueue<Integer> destination;
    private int load;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getElevatorNo() {
        return elevatorNo;
    }

    public Elevator(int limit, int elevatorNo) {
        this.limit = limit;
        this.elevatorNo = elevatorNo;
        currentStatus = ElevatorStatus.IDLE;
        currentFloor = 1;
        currentDir = null;
        destination = new PriorityQueue<>();
        load = 0;
    }

    void moveUp() {
        currentFloor++;
        currentDir = Direction.UP;
        currentStatus = ElevatorStatus.MOVING;
    }

    void moveDown() {
        currentFloor--;
        currentDir = Direction.DOWN;
        currentStatus = ElevatorStatus.MOVING;
    }

    public ElevatorStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(ElevatorStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

    public PriorityQueue<Integer> getDestination() {
        return destination;
    }

}
