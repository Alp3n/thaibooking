package entities.room;

import entities.roomFacility.RoomFacility;
import entities.bed.Bed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "rId")
    private Integer id;
    @Column(name = "rName")
    private String name;
    @Column(name = "rSize")
    private Integer size;
    @Column(name = "rPriceNight")
    private Integer priceNight;

    private List<RoomFacility> roomFacilities = new ArrayList<>();

    private List<Bed> beds = new ArrayList<>();

    public Room() {
    }

    public Room(String name, Integer size, Integer priceNight, List<RoomFacility> roomFacilities, List<Bed> beds) {
        this.name = name;
        this.size = size;
        this.priceNight = priceNight;
        this.roomFacilities = roomFacilities;
        this.beds = beds;
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

    public List<RoomFacility> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(List<RoomFacility> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", priceNight=" + priceNight +
                ", roomFacilities=" + roomFacilities +
                ", beds=" + beds +
                '}';
    }
}
