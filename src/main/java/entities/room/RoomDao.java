package entities.room;

import javax.swing.*;
import java.util.List;

public interface RoomDao {

    // Room DAO
    void listAllRoomsInProperty(JTable table, Integer propertyId);
    //
    void listPropertyRoomsSearch(Integer propertyId);
    boolean insertRoomInProperty(Integer propertyId);
    boolean updateRoomInProperty(Integer propertyId);

    // Room Facility DAO
    void listAllRoomFacilities(JList ItemList, Integer roomId);
    boolean insertRoomFacility(Integer roomId);

}

