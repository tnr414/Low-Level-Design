package BookMyShow;

public class Seat {
    private final int seatNumber;
    private  final SeatType seatType;
    private double pricing;
    private SeatStatus status;

    public Seat(SeatType seatType, double pricing, int seatNumber) {
        this.seatType = seatType;
        this.pricing = pricing;
        this.seatNumber = seatNumber;
        this.status = SeatStatus.EMPTY;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public double getPricing() {
        return pricing;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
