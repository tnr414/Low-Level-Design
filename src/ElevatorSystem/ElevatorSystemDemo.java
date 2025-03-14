package ElevatorSystem;

public class ElevatorSystemDemo {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        Elevator elevator = elevatorSystem.requestElevator(5);
        if (elevator == null) {
            System.out.println("Oops all elevator are currently full, please wait");
        } else {
            System.out.println("Got elevator no: " + elevator.getElevatorNo());
            elevatorSystem.requestDestination(elevator, 10);
        }
    }
}
