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

        if (rs.getString("uType").equalsIgnoreCase("regular")) {

            Regular user = new Regular();

            user.setId(rs.getInt("uId"));
            user.setfName(rs.getString("uFirstName"));
            user.setlName(rs.getString("uLastName"));
            user.setEmail(rs.getString("uEmail"));
            user.setPassword(rs.getString("uPassword"));
            user.setPassport(rs.getString("uPassport"));
            user.setPhone(rs.getString("uPhone"));
            user.setType(rs.getString("uType"));

            return user;

        } else if (rs.getString("uType").equalsIgnoreCase("partner")) {

            Partner user = new Partner();

            user.setId(rs.getInt("uId"));
            user.setfName(rs.getString("uFirstName"));
            user.setlName(rs.getString("uLastName"));
            user.setEmail(rs.getString("uEmail"));
            user.setPassword(rs.getString("uPassword"));
            user.setPassport(rs.getString("uPassport"));
            user.setPhone(rs.getString("uPhone"));
            user.setType(rs.getString("uType"));


            return user;
        }

        return null;
    }

    @Override
    public User getUser(Integer uId) {
        String sql =
                "SELECT *\n" +
                "FROM\n" +
                "   user\n" +
                "WHERE uId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, uId);
            ResultSet rs = ps.executeQuery();

            try {
                if (rs.next()) {
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
    public boolean insertRegular(String fName, String lName, String passport, String email, String phone, String pass) {
        String sql =
                "INSERT INTO user (uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uType)\n" +
                        "VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, passport);
                ps.setString(4, email);
                ps.setString(5, phone);
                ps.setString(6, pass);
                ps.setString(7, "Regular");

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

    @Override
    public boolean insertPartner(String fName, String lName, String passport, String email, String phone, String pass) {

        String sql =
                "INSERT INTO user (uFirstName, uLastName, uPassport, uEmail, uPhone, uPassword, uType)\n" +
                "VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setString(1, fName);
                ps.setString(2, lName);
                ps.setString(3, passport);
                ps.setString(4, email);
                ps.setString(5, phone);
                ps.setString(6, pass);
                ps.setString(7, "Partner");


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

    @Override
    public boolean insertGuest() {
        return false;
    }
}
