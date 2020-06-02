package entities.property;

import javax.swing.*;
import java.util.List;

public interface PropertyDao {

    void listAllProperties(JTable table);

//    List<Property> listAllProperties();
    List<Property> listAllPropertiesSearch();
    List<Property> listAllPartnerProperties();
    boolean insertProperty();
    boolean updateProperty();

    void listAllPropertyFacilities(JList ItemList, Integer propertyId);
    boolean insertPropertyFacility(Integer propertyId);
    boolean updatePropertyFacility(Integer propertyId);

    boolean insertPropertyType();
    boolean updatePropertyType();
}
