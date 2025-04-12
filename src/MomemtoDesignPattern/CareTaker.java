package MomemtoDesignPattern;

import java.util.Stack;

public class CareTaker {
    private Stack<Momento> history = new Stack<>();

    public void save(Originator originator) {
        history.push(originator.saveMomento());
    }

    public void undo(Originator originator) {
        if (!history.isEmpty()) {
            originator.restoreFromMomento(history.pop());
        }
    }
}
