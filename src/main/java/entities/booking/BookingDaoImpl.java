package entities.booking;

import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.awt.print.Book;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class BookingDaoImpl implements BookingDao {

    @Override
    public Booking extractBookingFromResultSet(ResultSet rs) throws SQLException {

        Booking booking = new Booking();

        booking.setId((rs.getInt("bId")));
        booking.setStatus((rs.getString("bStatus")));
        booking.setCheckIn((rs.getDate("bCheckIn").toLocalDate()));
        booking.setCheckOut((rs.getDate("bCheckOut").toLocalDate()));
        booking.setRoomId((rs.getInt("roomId")));
        booking.setPropertyId((rs.getInt("roomPropertyId")));
        booking.setUserId((rs.getInt("userId")));
        booking.setPaymentId((rs.getInt("paymentId")));

        return booking;
    }

    @Override
    public Booking getBooking(Integer bId) {

        String sql =
                "SELECT *\n" +
                "FROM\n" +
                "    booking\n" +
                "WHERE bId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bId);
            ResultSet rs = ps.executeQuery();

            try {
                if (rs.next()) {
                    return extractBookingFromResultSet(rs);
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
    public void tableAllRegularBookings(JTable table, Integer userId, String status) {
        String sql =
                "SELECT " +
                "   bId AS 'ID',\n" +
                "   bCheckIn AS 'Check in',\n" +
                "   bCheckOut AS 'Check out',\n" +
                "   rName AS 'Room',\n" +
                "   pName AS 'Property'\n" +
                "FROM booking\n" +
                "LEFT JOIN room r on booking.roomId = r.rId and booking.roomPropertyId = r.propertyId\n" +
                "LEFT JOIN property p on r.propertyId = p.pId\n" +
                "WHERE booking.userId = ? AND bStatus = ?" +
                "ORDER BY `Check in`";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, status);
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
    public boolean createBooking(Integer userId, Integer roomId, Integer propertyId, Integer paymentId, LocalDate checkIn, LocalDate checkOut, String status) {
        String sql =
                "INSERT INTO booking\n" +
                "(\n" +
                "    bCheckIn,\n" +
                "    bCheckOut,\n" +
                "    bStatus,\n" +
                "    paymentId,\n" +
                "    userId,\n" +
                "    roomId,\n" +
                "    roomPropertyId\n" +
                ")\n" +
                "VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setDate(1, Date.valueOf(checkIn));
                ps.setDate(2, Date.valueOf(checkOut));
                ps.setString(3, status);
                ps.setInt(4, paymentId);
                ps.setInt(5, userId);
                ps.setInt(6, roomId);
                ps.setInt(7, propertyId);

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
    public boolean cancelBooking(Integer customerId) {
        return false;
    }


    @Override
    public void tableAllPartnerBookings(JTable table, Integer propertyId, String status) {

        String sql =
                "SELECT " +
                "   bId AS 'ID',\n" +
                "   bCheckIn AS 'Check in',\n" +
                "   bCheckOut AS 'Check out',\n" +
                "   rName AS 'Room'\n" +
                "FROM booking\n" +
                "LEFT JOIN room r on booking.roomId = r.rId and booking.roomPropertyId = r.propertyId\n" +
                "WHERE roomPropertyId = ? AND bStatus = ?" +
                "ORDER BY `Check in`";


        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, propertyId);
            ps.setString(2, status);
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
    public boolean checkInBooking(Integer bookingId) {

        String sql =
                "UPDATE booking\n" +
                "SET bStatus = ?\n" +
                "WHERE bId = ?;";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            try {
                ps.setInt(2, bookingId);
                ps.setString(1,"Checked in");

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
    public boolean checkOutBooking(Integer bookingId) {
        String sql =
                "UPDATE booking\n" +
                        "SET bStatus = ?\n" +
                        "WHERE bId = ?;";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            try {
                ps.setInt(2, bookingId);
                ps.setString(1,"Archived");

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
    public boolean cancelPartnerBooking(Integer roomId) {
        return false;
    }
}
