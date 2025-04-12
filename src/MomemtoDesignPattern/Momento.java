package MomemtoDesignPattern;

public class Momento {
    private final String state;

    Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
