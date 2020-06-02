package entities.property;

import net.proteanit.sql.DbUtils;
import utils.JDBCUtil;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class PropertyDaoImpl implements PropertyDao {

    @Override
    public void listAllProperties(JTable table) {
        String sql =
                "SELECT " +
                "pId AS 'ID'," +
                "pName AS 'Name'," +
                "pCity AS 'City'," +
                "pDistrict AS 'District'" +
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
    public List<Property> listAllPropertiesSearch() {
        return null;
    }

    @Override
    public List<Property> listAllPartnerProperties() {
        return null;
    }

    @Override
    public boolean insertProperty() {
        return false;
    }

    @Override
    public boolean updateProperty() {
        return false;
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
    public boolean insertPropertyFacility(Integer propertyId) {
        return false;
    }

    @Override
    public boolean updatePropertyFacility(Integer propertyId) {
        return false;
    }

    @Override
    public boolean insertPropertyType() {
        return false;
    }

    @Override
    public boolean updatePropertyType() {
        return false;
    }
}
