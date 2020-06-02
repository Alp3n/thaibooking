package entities.room;

import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

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
    public boolean insertRoomInProperty(Integer propertyId) {
        return false;
    }

    @Override
    public boolean updateRoomInProperty(Integer propertyId) {
        return false;
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
    public boolean insertRoomFacility(Integer roomId) {
        return false;
    }
}
