package entities.room;

public class RoomFacility {

    private Integer id;
    private String name;

    private Integer roomId;

    public RoomFacility(Integer roomId){
        this.roomId = roomId;
    }

    public RoomFacility(String name) {
        this.name = name;
    }

    public RoomFacility(String name, Integer roomId) {
        this.name = name;
        this.roomId = roomId;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return name;
    }
}
