package MomemtoDesignPattern;

public class MomentoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        careTaker.save(originator);

        originator.setState("State #2");
        careTaker.save(originator);

        originator.setState("State #3");

        System.out.println("Current state: " + originator.getState());
        careTaker.undo(originator);
        System.out.println("After one undo: " + originator.getState());
        careTaker.undo(originator);
        System.out.println("After second undo: " + originator.getState());
    }
}
