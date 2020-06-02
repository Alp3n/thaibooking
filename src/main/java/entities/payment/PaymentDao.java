package entities.payment;

public interface PaymentDao {

    boolean createPayment();

    boolean insertPaymentToBooking(Integer bookingId);
    boolean updatePaymentInBooking(Integer bookingId);

}
