package entities.payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public Payment extractPaymentFromResultSet(ResultSet rs) throws SQLException {

        Payment payment = new Payment();

        payment.setId((rs.getInt("pId")));
        payment.setType((rs.getString("pType")));
        payment.setStatus((rs.getString("pStatus")));

        return payment;
    }

    @Override
    public boolean createPayment() {
        return false;
    }

    @Override
    public boolean insertPaymentToBooking(Integer bookingId) {
        return false;
    }

    @Override
    public boolean updatePaymentInBooking(Integer bookingId) {
        return false;
    }
}
