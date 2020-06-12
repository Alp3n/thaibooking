package entities.room;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface RoomDao {

    // Room DAO
    void listAllRoomsInProperty(JTable table, Integer propertyId);
    void tableAllRooms(JTable table, Integer propertyId);
    Room extractRoomFromResultSet(ResultSet rs) throws SQLException;
    Room listAvailablePropertyRoomsSearch(JTable table, Integer propertyId, LocalDate checkIn, LocalDate checkOut);

    Room getRoom(Integer roomId);

    boolean insertRoom(String name, Integer number, Integer price, Integer size, Integer propertyId);
    boolean deleteRoom(Integer roomId,Integer propertyId);

    // Room Facility DAO
    RoomFacility extractRoomFacilityFromResultSet(ResultSet rs) throws SQLException;
    void listAllRoomFacilities(JList ItemList, Integer roomId);
    boolean insertRoomFacility(Integer roomId, Integer roomFacilityId);
    RoomFacility getRoomFacility(JComboBox comboBox);

}

