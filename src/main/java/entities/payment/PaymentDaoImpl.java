package entities.payment;

import utils.JDBCUtil;

import java.sql.*;

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
    public Payment getPayment(Integer pId) {
        String sql =
                "SELECT *\n" +
                "FROM payment";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            try {
                while (rs.next()) {
                    return extractPaymentFromResultSet(rs);
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
