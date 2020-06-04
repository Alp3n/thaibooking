package entities.booking;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BookingDao {

    Booking extractBookingFromResultSet(ResultSet rs) throws SQLException;

    Booking getBooking(Integer bId);

    void tableAllRegularBookings(JTable table, Integer userId, String status);
//    void tableAllCustomerArchiveBookings(JTable table, Integer userId, String status);

    boolean createBooking(Integer userId);
    boolean cancelBooking(Integer userId);


    void tableAllPartnerBookings(JTable table, Integer propertyId, String status);
    /*void tableAllPartnerCheckedInBookings(JTable table, Integer propertyId, String status);
    void tableAllPartnerArchivedInBookings(JTable table, Integer propertyId, String status);*/

    boolean checkInBooking();
    boolean checkOutBooking();
    boolean cancelPartnerBooking(Integer roomId);
}
