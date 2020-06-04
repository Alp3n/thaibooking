package entities.user;

public class Partner extends User {

    private Integer propertyId;

    public Partner(String fName, String lName, String email, String phone, String password, String passport, Integer propertyId, String type) {
        super(fName, lName, email, phone, password, passport, type);
        this.propertyId = propertyId;
    }

    public Partner() {
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }
}
