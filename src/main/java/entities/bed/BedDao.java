package entities.bed;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BedDao {

    Bed extractBedFromResultSet(ResultSet rs) throws SQLException;

    void listAllBedsInRoom(JTable table, Integer roomId);
    void tableAllBeds(JTable table, Integer roomId);
    boolean insertBed(String name, Integer capacity, Integer roomId);
    boolean deleteBed(Integer roomId);
}
