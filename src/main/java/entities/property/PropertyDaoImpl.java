package entities.property;

import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.sql.*;


public class PropertyDaoImpl implements PropertyDao {

    @Override
    public Property extractPropertyFromResultSet(ResultSet rs) throws SQLException {

        Property property = new Property();

        property.setId((rs.getInt("pId")));
        property.setStars((rs.getString("pStars")));
        property.setName((rs.getString("pName")));
        property.setDescription((rs.getString("pDescription")));
        property.setRoad((rs.getString("pRoad")));
        property.setDistrict((rs.getString("pDistrict")));
        property.setCity((rs.getString("pCity")));
        property.setZipCode((rs.getString("pZipCode")));
        property.setEmail((rs.getString("pEmail")));
        property.setPhone((rs.getString("pPhone")));
        property.setCheckInTime((rs.getString("pCheckInTime")));
        property.setCheckOutTime((rs.getString("pCheckOutTime")));
        property.setPropertyType((rs.getInt("propertyType")));
        property.setPartner((rs.getInt("userId")));

        return property;
    }

    @Override
    public Property getPropertyByPropertyId(Integer propertyId) {
        String sql =
                "SELECT *\n" +
                "FROM property\n" +
                "WHERE pId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, propertyId);
            ResultSet rs = ps.executeQuery();

            try {
                while (rs.next()) {
                    return extractPropertyFromResultSet(rs);
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
    public Property getPropertyByUserId(Integer userId) {

        String sql =
                "SELECT *\n" +
                "FROM property\n" +
                "WHERE userId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            try {
                while (rs.next()) {
                    return extractPropertyFromResultSet(rs);
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
    public PropertyType extractPropertyTypeFromResultSet(ResultSet rs) throws SQLException {

        PropertyType propertyType = new PropertyType();

        propertyType.setId((rs.getInt("ptId")));
        propertyType.setName((rs.getString("ptName")));

        return propertyType;
    }

    @Override
    public PropertyFacility extractPropertyFacilityFromResultSet(ResultSet rs) throws SQLException {

        PropertyFacility propertyFacility = new PropertyFacility();

        propertyFacility.setId((rs.getInt("pfId")));
        propertyFacility.setName((rs.getString("pfName")));

        return propertyFacility;
    }

    @Override
    public void listAllProperties(JTable table) {
        String sql =
                "SELECT " +
                "pId AS 'ID'," +
                "pName AS 'Name'," +
                "pCity AS 'City'," +
                "pDistrict AS 'District'," +
                "pRoad AS 'Road'" +
                "FROM property";

        try (Connection conn = JDBCUtil.getConnection();
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            try {
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } finally {
                rs.close();
                st.close();
                conn.close();
            }

        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    }

    @Override
    public Property listAllPropertiesSearch(JTable table, String searchPhrase) {

        String sql =
                "SELECT " +
                "pId AS 'ID', " +
                "pName AS 'Name', " +
                "pCity AS 'City', " +
                "pDistrict AS 'District', " +
                "pRoad AS 'Road' " +
                "FROM " +
                "   property " +
                "WHERE CONCAT(pName, pDistrict, pCity, pRoad, pZipCode) " +
                "LIKE CONCAT('%',?,'%')";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, searchPhrase );
            ResultSet rs = ps.executeQuery();

            try {
                table.setModel(DbUtils.resultSetToTableModel(rs));
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
    public PropertyType getPropertyTypes(JComboBox comboBox) {
        String sql =
                "SELECT * " +
                "FROM property_type";

        try (Connection conn = JDBCUtil.getConnection();
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            try {
                while (rs.next()) {
                    comboBox.addItem(extractPropertyTypeFromResultSet(rs));
                }
            } finally {
                rs.close();
                st.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public PropertyFacility getPropertyFacility(JComboBox comboBox) {
        String sql =
                "SELECT *\n" +
                "FROM property_facility";

        try (Connection conn = JDBCUtil.getConnection();
             Statement st = conn.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            try {
                while (rs.next()) {
                    comboBox.addItem(extractPropertyFacilityFromResultSet(rs));
                }
            } finally {
                rs.close();
                st.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    /*@Override
    public Property getPartnerProperty(Integer partnerId) {
        String sql =
                "SELECT *\n" +
                "FROM property\n" +
                "WHERE userId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, partnerId);
            ResultSet rs = ps.executeQuery();

            try {
                while (rs.next()) {
                    return extractPropertyFromResultSet(rs);
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
    }*/

    @Override
    public boolean insertProperty(String pStars, String pName, String pDescription, String pRoad, String pDistrict, String pCity, String pZipCode, String pEmail, String pPhone, String pCheckIn, String pCheckOut, Integer userId, Integer propertyType) {

        String sql =
                "INSERT INTO property\n" +
                "(\n" +
                "    pStars,\n" +
                "    pName,\n" +
                "    pDescription,\n" +
                "    pRoad,\n" +
                "    pDistrict,\n" +
                "    pCity,\n" +
                "    pZipCode,\n" +
                "    pEmail,\n" +
                "    pPhone,\n" +
                "    pCheckInTime,\n" +
                "    pCheckOutTime,\n" +
                "    propertyType,\n" +
                "    userId\n" +
                ")\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setString(1, pStars);
                ps.setString(2, pName);
                ps.setString(3, pDescription);
                ps.setString(4, pRoad);
                ps.setString(5, pDistrict);
                ps.setString(6, pCity);
                ps.setString(7, pZipCode);
                ps.setString(8, pEmail);
                ps.setString(9, pPhone);
                ps.setString(10, pCheckIn);
                ps.setString(11, pCheckOut);
                ps.setInt(12, propertyType);
                ps.setInt(13, userId);

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
    public boolean updateProperty(String pStars, String pName, String pDescription, String pRoad, String pDistrict, String pCity, String pZipCode, String pEmail, String pPhone, String pCheckIn, String pCheckOut, Integer userId, Integer propertyType, Integer propertyId) {

        String sql =
                "UPDATE property\n" +
                "\n" +
                "SET" +
                "    pStars = ?,\n" +
                "    pName = ?,\n" +
                "    pDescription = ?,\n" +
                "    pRoad = ?,\n" +
                "    pDistrict = ?,\n" +
                "    pCity = ?,\n" +
                "    pZipCode = ?,\n" +
                "    pEmail = ?,\n" +
                "    pPhone = ?,\n" +
                "    pCheckInTime = ?,\n" +
                "    pCheckOutTime = ?,\n" +
                "    propertyType = ?,\n" +
                "    userId = ?\n" +
                "\n" +
                "WHERE pId = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setString(1, pStars);
                ps.setString(2, pName);
                ps.setString(3, pDescription);
                ps.setString(4, pRoad);
                ps.setString(5, pDistrict);
                ps.setString(6, pCity);
                ps.setString(7, pZipCode);
                ps.setString(8, pEmail);
                ps.setString(9, pPhone);
                ps.setString(10, pCheckIn);
                ps.setString(11, pCheckOut);
                ps.setInt(12, propertyType);
                ps.setInt(13, userId);
                ps.setInt(14, propertyId);

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
    public void listAllPropertyFacilities(JList ItemList, Integer propertyId) {

        DefaultListModel model = new DefaultListModel();

        String sql =
                "SELECT\n" +
                "    pfName\n" +
                "FROM\n" +
                "    property_has_property_facility\n" +
                "LEFT JOIN property_facility ON\n" +
                "    property_facility.pfId = property_has_property_facility.propertyFacilityId\n" +
                "WHERE propertyId = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, propertyId);
            ResultSet rs = ps.executeQuery();


            try {
                while (rs.next()) {
                    String item = rs.getString("pfName");
                    model.addElement(item);
                }
                ItemList.setModel(model);
            } finally {
                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean insertPropertyFacility(Integer propertyFacilityId,Integer propertyId) throws SQLException{

        String sql =
                "INSERT INTO property_has_property_facility\n" +
                "(\n" +
                "    propertyId,\n" +
                "    propertyFacilityId\n" +
                ")\n" +
                "VALUES (?,?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            try {
                ps.setInt(1, propertyId);
                ps.setInt(2, propertyFacilityId);

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
