package entities.property;

import entities.user.User;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PropertyDao {

    Property getPropertyByPropertyId(Integer propertyId);
    Property getPropertyByUserId(Integer userId);

    void listAllProperties(JTable table);
    Property extractPropertyFromResultSet(ResultSet rs) throws SQLException;

    Property listAllPropertiesSearch(JTable table, String searchPhrase);

    boolean insertProperty(String pStars, String pName, String pDescription, String pRoad, String pDistrict, String pCity, String pZipCode, String pEmail, String pPhone, String pCheckIn, String pCheckOut, Integer userId, Integer propertyType);
    boolean updateProperty(String pStars, String pName, String pDescription, String pRoad, String pDistrict, String pCity, String pZipCode, String pEmail, String pPhone, String pCheckIn, String pCheckOut, Integer userId, Integer propertyType, Integer propertyId);

    PropertyFacility extractPropertyFacilityFromResultSet(ResultSet rs) throws SQLException;
    void listAllPropertyFacilities(JList ItemList, Integer propertyId);
    PropertyFacility getPropertyFacility(JComboBox comboBox);
    boolean insertPropertyFacility(Integer propertyFacilityId, Integer propertyId) throws SQLException;


    PropertyType extractPropertyTypeFromResultSet(ResultSet rs) throws SQLException;
    PropertyType getPropertyTypes(JComboBox comboBox);
}
