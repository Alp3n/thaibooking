package entities.room;

import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public void tableAllRooms(JTable table, Integer propertyId) {

        String sql =
                "SELECT\n" +
                "    r.rId AS 'ID',\n" +
                "    r.rName AS 'Type',\n" +
                "    r.rNumber AS 'Number',\n" +
                "    r.rPrice AS 'Price',\n" +
                "    r.rSize AS 'Size(m2)'\n" +
                "FROM\n" +
                "    room r\n" +
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
                "    r.rId AS 'ID',\n" +
                "    r.rName AS 'Type',\n" +
                "    r.rPrice AS 'Price',\n" +
                "    b.capacity AS 'Max Guests'\n" +
                "FROM\n" +
                "    room r,\n" +
                "(SELECT roomId, SUM(bCapacity) as capacity FROM bed group by roomId) as b\n" +
                "WHERE r.rId = b.roomId AND r.propertyId = ?";

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
                    return extractRoomFromResultSet(rs);
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
    public Room listAvailablePropertyRoomsSearch(JTable table, Integer propertyId, LocalDate checkIn, LocalDate checkOut) {

        String sql =
                "SELECT r.rid            AS 'ID',\n" +
                "       r.rname          AS 'Room Type',\n" +
                "       r.rprice         AS 'Price (THB)',\n" +
                "       Sum(b.bcapacity) AS 'Max Guests'\n" +
                "FROM   room r\n" +
                "           LEFT JOIN bed b\n" +
                "                     ON r.rid = b.roomid\n" +
                "WHERE propertyId =? AND  NOT EXISTS (SELECT 1\n" +
                "                   FROM   booking bo\n" +
                "                   WHERE  bo.roomid = r.rid\n" +
                "                     AND bo.bcheckin < ?\n" +
                "                     AND bo.bcheckout >= ?)\n" +
                "GROUP  BY roomid";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, propertyId);
            ps.setDate(2, Date.valueOf(checkOut));
            ps.setDate(3, Date.valueOf(checkIn));
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

        return null;
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
