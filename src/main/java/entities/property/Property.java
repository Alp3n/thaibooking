package entities.property;

import entities.user.Partner;
import entities.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private Integer id;
    private String name;
    private String description;
    private String road;
    private String district;
    private String city;
    private String zipCode;
    private String country;
    private String phone;
    private String email;
    private String checkInTime;
    private String checkOutTime;

    private Partner partner;

    private PropertyType propertyType;

    private List<PropertyFacility> propertyFacilities = new ArrayList<>();

    private List<Room> rooms = new ArrayList<>();

    public Property(){}

    public Property(String name, String description, String road, String district, String city, String zipCode, String country, String phone, String email, String checkInTime, String checkOutTime, Partner partner, PropertyType propertyType, List<PropertyFacility> propertyFacilities, List<Room> rooms) {
        this.name = name;
        this.description = description;
        this.road = road;
        this.district = district;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.partner = partner;
        this.propertyType = propertyType;
        this.propertyFacilities = propertyFacilities;
        this.rooms = rooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public List<PropertyFacility> getPropertyFacilities() {
        return propertyFacilities;
    }

    public void setPropertyFacilities(List<PropertyFacility> propertyFacilities) {
        this.propertyFacilities = propertyFacilities;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", road='" + road + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                ", propertyType=" + propertyType +
                ", propertyFacilities=" + propertyFacilities +
                ", rooms=" + rooms +
                '}';
    }


}
