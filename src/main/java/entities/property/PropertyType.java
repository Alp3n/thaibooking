package entities.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyType {

    private Integer id;
    private String name;

    public PropertyType(){}


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
        return name;
    }


}
