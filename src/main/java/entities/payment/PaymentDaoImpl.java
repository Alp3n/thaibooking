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
        payment.setTotal((rs.getInt("pTotal")));

        return payment;
    }

    @Override
    public Payment getPayment(Integer pId) {
        String sql =
                "SELECT *\n" +
                "FROM payment " +
                "WHERE pId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pId);
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
    public Integer insertPaymentToBooking(String pType, String pStatus, Integer pTotal) {

        String sql =
                "INSERT INTO payment\n" +
                "(\n" +
                "    pType,\n" +
                "    pStatus,\n" +
                "    pTotal\n" +
                ")\n" +
                "VALUES (?,?,?)";

        Integer paymentId = null;

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            try {
                ps.setString(1, pType);
                ps.setString(2, pStatus);
                ps.setInt(3, pTotal);
                ps.executeUpdate();

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        paymentId = generatedKeys.getInt(1);
                    }
                }
            } finally {
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return paymentId;
    }

    @Override
    public boolean updatePaymentInBooking(Integer paymentId) {

        String sql =
                "UPDATE payment\n" +
                "SET pStatus = ?\n" +
                "WHERE pId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            try {
                ps.setInt(2, paymentId);
                ps.setString(1,"Paid");

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
}
