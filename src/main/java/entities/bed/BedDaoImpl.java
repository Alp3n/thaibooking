package entities.bed;

import entities.room.RoomFacility;
import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BedDaoImpl implements BedDao {


    @Override
    public Bed extractBedFromResultSet(ResultSet rs) throws SQLException {

        Bed bed = new Bed();

        bed.setId((rs.getInt("bId")));
        bed.setName((rs.getString("bName")));
        bed.setCapacity((rs.getInt("bCapacity")));

        return bed;
    }


    @Override
    public void listAllBedsInRoom(JTable table, Integer roomId) {
        String sql =
                "SELECT\n" +
                "    bName AS 'Bed Type',\n" +
                "    bCapacity AS 'Capacity'\n" +
                "FROM\n" +
                "    bed\n" +
                "WHERE roomId = ?";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomId);
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
    public void tableAllBeds(JTable table, Integer roomId) {
        String sql =
                "SELECT\n" +
                "    bId AS 'ID',\n" +
                "    bName AS 'Bed Type',\n" +
                "    bCapacity AS 'Capacity'\n" +
                "FROM\n" +
                "    bed\n" +
                "WHERE roomId = ?";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomId);
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
    public boolean insertBed(String name, Integer capacity, Integer roomId) {

        String sql =
                "INSERT INTO bed\n" +
                "(\n" +
                "    bName,\n" +
                "    bCapacity,\n" +
                "    roomId\n" +
                ")\n" +
                "VALUES (?,?,?)";

        try (Connection conn = JDBCUtil.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setString(1, name);
                ps.setInt(2, capacity);
                ps.setInt(3, roomId);

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
    public boolean deleteBed(Integer bedId) {

        String sql =
                "DELETE FROM bed\n" +
                "WHERE bId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setInt(1, bedId);

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
}
