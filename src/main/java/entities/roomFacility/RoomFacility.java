package entities.roomFacility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RoomFacility {

    @Id
    @GeneratedValue
    @Column(name = "rfId")
    private Integer id;
    @Column(name = "rfName")
    private String name;

    public RoomFacility(){}

    public RoomFacility(String name) {
        this.name = name;
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
}
