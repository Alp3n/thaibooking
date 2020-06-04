package entities.user;

public class Regular extends User {

    private Integer bookingId;

    public Regular(String fName, String lName, String email, String phone, String password, String passport, String type) {
        super(fName, lName, email, phone, password, passport, type);
    }

    public Regular() {
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

}
