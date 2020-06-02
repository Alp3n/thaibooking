package entities.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyFacility {

    private Integer id;
    private String name;

    private List<Property> properties = new ArrayList<>();

    public PropertyFacility(){}

    public PropertyFacility(String name, List<Property> properties) {
        this.name = name;
        this.properties = properties;
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

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
