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
    public boolean insertBed() {
        return false;
    }

    @Override
    public boolean deleteBed() {
        return false;
    }
}
