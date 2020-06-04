package entities.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyFacility {

    private Integer id;
    private String name;


    public PropertyFacility(){}

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

    @Override
    public String toString() {
        return name;
    }
}
