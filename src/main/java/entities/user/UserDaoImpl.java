package entities.user;

import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String sql =
                "SELECT *\n" +
                "FROM user\n" +
                "WHERE uEmail = ? AND uPassword = ?;";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            try {
                if(rs.next()) {
                    return extractUserFromResultSet(rs);
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
    public User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId(rs.getInt("uId"));
        user.setfName(rs.getString("uFirstName"));
        user.setlName(rs.getString("uLastName"));
        user.setEmail(rs.getString("uEmail"));
        user.setPassword(rs.getString("uPassword"));
        user.setPassport(rs.getString("uPassport"));
        user.setPhone(rs.getString("uPhone"));

        return user;
    }

    @Override
    public boolean insertCustomer() {
        return false;
    }

    @Override
    public boolean insertPartner() {
        return false;
    }

    @Override
    public boolean insertGuest() {
        return false;
    }
}
