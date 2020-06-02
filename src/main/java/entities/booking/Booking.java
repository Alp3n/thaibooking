package entities.booking;

import java.time.*;

public class Booking {

    private Integer id;
    private String status;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer nights;
    private Integer numberOfGuests;
    private Integer roomId;
    private Integer propertyId;
    private Integer customerId;
    private Integer guestId;
    private Integer paymentId;

    public Booking(String status,LocalDate checkIn, LocalDate checkOut, Integer nights, Integer numberOfGuests, Integer propertyId, Integer roomId, Integer customerId, Integer guestId, Integer paymentId) {
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
        this.numberOfGuests = numberOfGuests;
        this.propertyId = propertyId;
        this.roomId = roomId;
        this.customerId = customerId;
        this.guestId = guestId;
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
}
