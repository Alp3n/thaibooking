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
        booking.setNumberOfGuests((rs.getInt("bGuests")));
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
                    /*Integer bookingId = rs.getInt(1);
                    LocalDate checkIn = rs.getDate(2).toLocalDate();
                    LocalDate checkOut = rs.getDate(3).toLocalDate();
                    String fName = rs.getString(4);
                    String lName = rs.getString(5);
                    String passport = rs.getString(6);
                    Integer roomNumber = rs.getInt(7);
                    String bookingStatus = rs.getString(8);
                    String paymentType = rs.getString(9);
                    String paymentStatus = rs.getString(10);
                    Integer roomPrice = rs.getInt(11);*/
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

    }

    /*@Override
    public void tableAllCustomerArchiveBookings(JTable table, Integer userId, String status) {

    }*/

    @Override
    public boolean createBooking(Integer customerId) {
        return false;
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
                "WHERE roomPropertyId = ? AND bStatus = ?";


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

    /*@Override
    public void tableAllPartnerCheckedInBookings(JTable table, Integer propertyId, String status) {
        String sql =
                "SELECT *\n" +
                "FROM booking\n" +
                "WHERE roomPropertyId = ? AND bStatus = ?;";


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
    public void tableAllPartnerArchivedInBookings(JTable table, Integer propertyId, String status) {
        String sql =
                "SELECT *\n" +
                        "FROM booking\n" +
                        "WHERE roomPropertyId = ? AND bStatus = ?;";


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
    }*/

    @Override
    public boolean checkInBooking() {
        return false;
    }

    @Override
    public boolean checkOutBooking() {
        return false;
    }

    @Override
    public boolean cancelPartnerBooking(Integer roomId) {
        return false;
    }
}
