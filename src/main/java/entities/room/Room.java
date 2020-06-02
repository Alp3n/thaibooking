package entities.room;

import entities.booking.Booking;
import entities.property.Property;
import entities.bed.Bed;

import java.util.ArrayList;
import java.util.List;


public class Room {

    private Integer id;
    private String name;
    private Integer size;
    private Integer priceNight;
    private Integer roomNumber;
    private Integer propertyId;

    public Room(String name, Integer priceNight, Integer size) {
        this.name = name;
        this.priceNight = priceNight;
        this.size = size;
    }

    public Room(Integer id, String name, Integer size, Integer priceNight, Integer roomNumber, Integer propertyId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.priceNight = priceNight;
        this.roomNumber = roomNumber;
        this.propertyId = propertyId;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(Integer priceNight) {
        this.priceNight = priceNight;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }



    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", priceNight=" + priceNight +
                '}';
    }
}
