package MomemtoDesignPattern;

public class Originator {
    private String state;

    public Originator() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        System.out.println("Setting state to: " + state);
        this.state = state;
    }

    public Momento saveMomento() {
        return new Momento(state);
    }

    public void restoreFromMomento(Momento momento) {
        this.state = momento.getState();
    }
}
