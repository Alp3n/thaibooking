package entities.user;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {


    User getUserByEmailAndPassword(String email, String password);

    User extractUserFromResultSet(ResultSet rs) throws SQLException;

    User getUser(Integer bId);

    boolean insertRegular(String fName, String lName, String passport, String email, String phone, String pass);
    boolean insertPartner(String fName, String lName, String passport, String email, String phone, String pass);
    boolean insertGuest();
}
