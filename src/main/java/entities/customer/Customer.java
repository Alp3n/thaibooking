package entities.customer;

import entities.booking.Booking;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "cId")
    private Integer id;
    @Column(name = "cFirstName")
    private String fName;
    @Column(name = "cLastName")
    private String lName;
    @Column(name = "cEmail")
    private String email;
    @Column(name = "cPhone")
    private String phone;
    @Column(name = "cPassword")
    private String password;
    @Column(name = "cPassport")
    private String passport;

    @OneToMany(mappedBy = "booking")
    private List<Booking> bookings = new ArrayList<>();

    public Customer() {
    }

    public Customer(String fName, String lName, String email, String phone, String password, String passport, List<Booking> bookings) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.passport = passport;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", passport='" + passport + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
