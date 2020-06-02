package entities.booking;

import java.util.List;

public interface BookingDao {

    List<Booking> listAllCustomerBookings(Integer customerId);
    List<Booking> listAllCustomerPendingBookings(Integer customerId);
    List<Booking> listAllCustomerArchiveBookings(Integer customerId);

    boolean createCustomerBooking(Integer customerId);
    boolean cancelCustomerBooking(Integer customerId);


    List<Booking> listAllPartnerPendingBookings(Integer roomId);
    List<Booking> listAllPartnerCheckedInBookings(Integer roomId);
    List<Booking> listAllPartnerArchivedInBookings(Integer roomId);

    boolean checkInBooking();
    boolean checkOutBooking();
    boolean cancelPartnerBooking(Integer roomId);
}
