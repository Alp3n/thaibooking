package entities.user;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {


    User getUserByEmailAndPassword(String email, String password);

    User extractUserFromResultSet(ResultSet rs) throws SQLException;

    boolean insertCustomer();
    boolean insertPartner();
    boolean insertGuest();
}
