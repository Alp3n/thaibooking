package entities.booking;

import java.util.List;

public class BookingDaoImpl implements BookingDao {

    @Override
    public List<Booking> listAllCustomerBookings(Integer customerId) {
        return null;
    }

    @Override
    public List<Booking> listAllCustomerPendingBookings(Integer customerId) {
        return null;
    }

    @Override
    public List<Booking> listAllCustomerArchiveBookings(Integer customerId) {
        return null;
    }

    @Override
    public boolean createCustomerBooking(Integer customerId) {
        return false;
    }

    @Override
    public boolean cancelCustomerBooking(Integer customerId) {
        return false;
    }

    @Override
    public List<Booking> listAllPartnerPendingBookings(Integer roomId) {
        return null;
    }

    @Override
    public List<Booking> listAllPartnerCheckedInBookings(Integer roomId) {
        return null;
    }

    @Override
    public List<Booking> listAllPartnerArchivedInBookings(Integer roomId) {
        return null;
    }

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
