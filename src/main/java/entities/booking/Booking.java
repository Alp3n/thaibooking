package entities.booking;

import entities.customer.Customer;
import entities.guest.Guest;
import entities.payment.Payment;
import entities.room.Room;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    @Column(name = "bId")
    private Integer id;
    @Column(name = "bCheckIn")
    private Date checkIn;
    @Column(name = "bCheckOut")
    private Date checkOut;
    @Column(name = "bNights")
    private Integer nights;

    @ManyToOne
    @JoinColumn(name = "rId")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "cId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "gId")
    private Guest guest;

    @OneToOne
    @JoinColumn(name = "pId")
    private Payment payment;

    public Booking() {
    }

    public Booking(Date checkIn, Date checkOut, Integer nights, Room room, Customer customer, Guest guest, Payment payment) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
        this.room = room;
        this.customer = customer;
        this.guest = guest;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", nights=" + nights +
                ", room=" + room +
                ", customer=" + customer +
                ", guest=" + guest +
                ", payment=" + payment +
                '}';
    }
}
