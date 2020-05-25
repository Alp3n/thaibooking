package entities.guest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    @Column(name = "gId")
    private Integer id;
    @Column(name = "gFullName")
    private String fullName;
    @Column(name = "gPassport")
    private String passport;

    public Guest() {
    }

    public Guest(String fullName, String passport) {
        this.fullName = fullName;
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
