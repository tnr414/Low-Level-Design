package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private String name;
    private List<Show> showList;
    private final Location location;

    public Theatre(Location location, String name) {
        this.location = location;
        this.name = name;
        showList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addShow(Show show) {
        showList.add(show);
    }

    public void displayShow() {
        for (Show show: showList) {
            System.out.println("Theatre: "+name+","+" Movie: "+show.getMovie().getName()+", Start Time: "+show.getStartTime() +", End Time "+show.getEndTime());
        }
    }

    public List<Show> getShowList() {
        return showList;
    }

    public Location getLocation() {
        return location;
    }
}
