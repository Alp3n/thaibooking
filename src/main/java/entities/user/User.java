package entities.user;

public class User {

    private Integer id;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String password;
    private String passport;
    private String type;

    public User(){}

    public User(String fName, String lName, String email, String phone, String password, String passport, String type) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.passport = passport;
        this.type = type;
    }

    public User(String fName, String lName, String passport) {
        this.fName = fName;
        this.lName = lName;
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
