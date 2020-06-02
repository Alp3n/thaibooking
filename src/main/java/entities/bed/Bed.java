package entities.bed;

import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bed {

    private Integer id;
    private String name;
    private Integer capacity;
    private Integer roomId;

    public Bed() {
    }

    public Bed(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Bed(Integer id, String name, Integer capacity, Integer roomId) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
