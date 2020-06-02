package entities.user;

public class Guest extends User {

    private Integer bookingId;

    public Guest(String fName, String lName, String passport, Integer bookingId) {
        super(fName, lName, passport);
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
}
