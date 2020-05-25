package entities.bed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bed {

    @Id
    @GeneratedValue
    @Column(name = "bId")
    private Integer id;
    @Column(name = "bName")
    private String name;
    @Column(name = "bCapacity")
    private Integer capacity;

    public Bed() {
    }

    public Bed(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
