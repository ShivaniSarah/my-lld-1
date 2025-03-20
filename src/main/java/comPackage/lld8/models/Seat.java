package comPackage.lld8.models;

public class Seat {
    private final  String seatId;
    private final  SeatType seatType;
    private  SeatBookingStatus seatBookingStatus;

    public Seat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatBookingStatus = SeatBookingStatus.VACANT;
    }

    public synchronized void bookSeatBookingStatus() {

            if (this.seatBookingStatus.equals(SeatBookingStatus.VACANT)) {
                this.seatBookingStatus = SeatBookingStatus.BOOKED;
            }
    }
    public  void cancelSeatBookingStatus() {

            if (this.seatBookingStatus.equals(SeatBookingStatus.BOOKED)) {
                this.seatBookingStatus = SeatBookingStatus.VACANT;
            }

    }
}
