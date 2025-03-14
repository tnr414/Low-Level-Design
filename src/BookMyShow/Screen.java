package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int id;
    private List<Seat> seatList;

    public Screen(int id) {
        this.id = id;
        seatList = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seatList.add(seat);
    }

    public List<Seat> getSeatList() {
        return seatList;
    }
}


