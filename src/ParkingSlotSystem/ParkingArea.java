package ParkingSlotSystem;

import java.util.List;

public class ParkingArea {
    List<ParkingLevel> levels;

    public ParkingArea(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    public List<ParkingLevel> getLevels() {
        return levels;
    }


    public void addSlot(ParkingLevel level, Slot slot) {
        level.addSlot(slot);
    }
}
