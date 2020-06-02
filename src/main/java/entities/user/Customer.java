package entities.user;

public class Customer extends User {

    private Integer bookingId;

    public Customer(String fName, String lName, String email, String phone, String password, String passport, Integer bookingId) {
        super(fName, lName, email, phone, password, passport);
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
}
