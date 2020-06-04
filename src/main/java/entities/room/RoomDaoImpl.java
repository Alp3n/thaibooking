package entities.room;

import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public void tableAllRooms(JTable table, Integer propertyId) {
        String sql =
                "SELECT\n" +
                "    rId AS 'ID',\n" +
                "    rName AS 'Type',\n" +
                "    rNumber AS 'Number',\n" +
                "    rPrice AS 'Price',\n" +
                "    rSize AS 'Size(m2)',\n" +
                "    bCapacity AS 'Max Guests'\n" +
                "FROM\n" +
                "    room\n" +
                "LEFT JOIN bed ON\n" +
                "    bed.roomId =\n" +
                "    (SELECT COUNT(bCapacity))\n" +
                "WHERE propertyId = ?";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, propertyId);
            ResultSet rs = ps.executeQuery();


            try {
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } finally {
                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void listAllRoomsInProperty(JTable table, Integer propertyId) {

        String sql =
                "SELECT\n" +
                "    rId AS 'ID',\n" +
                "    rName AS 'Type',\n" +
                "    rPrice AS 'Price',\n" +
                "    bCapacity AS 'Max Guests'\n" +
                "FROM\n" +
                "    room\n" +
                "LEFT JOIN bed ON\n" +
                "    bed.roomId =\n" +
                "    (SELECT COUNT(bCapacity))\n" +
                "WHERE propertyId = ?";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, propertyId);
            ResultSet rs = ps.executeQuery();


            try {
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } finally {
                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Room extractRoomFromResultSet(ResultSet rs) throws SQLException {

        Room room = new Room();

            room.setId((rs.getInt("rId")));
            room.setName((rs.getString("rName")));
            room.setRoomNumber((rs.getInt("rNumber")));
            room.setPriceNight((rs.getInt("rPrice")));
            room.setSize((rs.getInt("rSize")));
            room.setPropertyId((rs.getInt("propertyId")));


        return room;
    }

    @Override
    public Room getRoom(Integer roomId) {
        String sql =
                "SELECT *\n" +
                "FROM room\n" +
                "WHERE rId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();

            try {
                while (rs.next()) {
                    extractRoomFromResultSet(rs);
                }
            } finally {
                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public RoomFacility extractRoomFacilityFromResultSet(ResultSet rs) throws SQLException {

        RoomFacility roomFacility = new RoomFacility();

        roomFacility.setId((rs.getInt("rfId")));
        roomFacility.setName((rs.getString("rfName")));

        return roomFacility;
    }

    // Room DAO
    @Override
    public void listPropertyRoomsSearch(Integer propertyId) {

        List<Room> roomArrayList = new ArrayList<>();

        String sql =
                "SELECT\n" +
                "   rName,\n" +
                "   rPrice,\n" +
                "   bCapacity\n" +
                "FROM\n" +
                "   room\n" +
                "LEFT JOIN bed ON\n" +
                "   bed.roomId =" +
                "(SELECT COUNT(bCapacity))\n" +
                "WHERE propertyId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, propertyId);
            ResultSet rs = ps.executeQuery();

            Room room;

            while(rs.next()) {
                room = new Room(
                        rs.getString("rName"),
                        rs.getInt("rPrice"),
                        rs.getInt("bCapacity")
                );

                roomArrayList.add(room);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean insertRoom(String name, Integer number, Integer price, Integer size, Integer propertyId) {

        String sql =
                "INSERT INTO room\n" +
                "(\n" +
                "    rName,\n" +
                "    rNumber,\n" +
                "    rPrice,\n" +
                "    rSize,\n" +
                "    propertyId\n" +
                ")\n" +
                "VALUES (?,?,?,?,?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setString(1, name);
                ps.setInt(2, number);
                ps.setInt(3, price);
                ps.setInt(4, size);
                ps.setInt(5, propertyId);


                ps.executeUpdate();
            } finally {
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteRoom(Integer roomId, Integer propertyId) {

        String sql =
                "DELETE FROM room\n" +
                "WHERE rId = ? AND propertyId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setInt(1, roomId);
                ps.setInt(2, propertyId);

                ps.executeUpdate();
            } finally {
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return true;
    }


    // Room Facility DAO
    @Override
    public void listAllRoomFacilities(JList ItemList, Integer roomId) {

        DefaultListModel model = new DefaultListModel();

        String sql =
                "SELECT\n" +
                "    rfName\n" +
                "FROM\n" +
                "    room_has_room_facility\n" +
                "LEFT JOIN room_facility ON\n" +
                "    room_facility.rfId = room_has_room_facility.roomFacilityId\n" +
                "WHERE roomId = ?";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();


            try {
                while (rs.next()) {
                    String item = rs.getString("rfName");
                    model.addElement(item);
                }
                ItemList.setModel(model);
            } finally {
                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean insertRoomFacility(Integer roomId, Integer roomFacilityId) {
        String sql =
                "INSERT INTO room_has_room_facility\n" +
                        "(\n" +
                        "    roomId,\n" +
                        "    roomFacilityId\n" +
                        ")\n" +
                        "VALUES (?,?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setInt(1, roomId);
                ps.setInt(2, roomFacilityId);

                ps.executeUpdate();
            } finally {
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public RoomFacility getRoomFacility(JComboBox comboBox) {
        String sql =
                "SELECT *\n" +
                "FROM room_facility";

        try (Connection conn = JDBCUtil.getConnection();
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            try {
                while (rs.next()) {
                    comboBox.addItem(extractRoomFacilityFromResultSet(rs));
                }
            } finally {
                rs.close();
                st.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
