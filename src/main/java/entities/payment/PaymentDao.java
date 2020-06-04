package entities.payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDao {

    Payment extractPaymentFromResultSet(ResultSet rs) throws SQLException;

    Payment getPayment(Integer pId);

    boolean createPayment();

    boolean insertPaymentToBooking(Integer bookingId);
    boolean updatePaymentInBooking(Integer bookingId);

}
