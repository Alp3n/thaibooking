package entities.payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentDao {

    Payment extractPaymentFromResultSet(ResultSet rs) throws SQLException;

    Payment getPayment(Integer pId);

    Integer insertPaymentToBooking(String pType, String pStatus, Integer pTotal);
    boolean updatePaymentInBooking(Integer paymentId);

}
