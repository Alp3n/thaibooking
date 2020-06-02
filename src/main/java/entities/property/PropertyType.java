package entities.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyType {

    private Integer id;
    private String name;

    private List<Property> property = new ArrayList<>();

    public PropertyType(){}

    public PropertyType(String name, List<Property> property) {
        this.name = name;
        this.property = property;
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

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "PropertyType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
