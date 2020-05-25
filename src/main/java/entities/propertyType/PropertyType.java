package entities.propertyType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PropertyType {

    @Id
    @GeneratedValue
    @Column(name = "ptId")
    private Integer id;
    @Column(name = "ptName")
    private String name;

    public PropertyType(){}

    public PropertyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PropertyType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
