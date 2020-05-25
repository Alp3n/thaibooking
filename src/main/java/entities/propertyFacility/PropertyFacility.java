package entities.propertyFacility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PropertyFacility {

    @Id
    @GeneratedValue
    @Column(name = "pfId")
    private Integer id;
    @Column(name = "pfName")
    private String name;

    public PropertyFacility(){}

    public PropertyFacility(String name) {
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
