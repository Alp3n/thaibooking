package entities.property;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtil;

public class PropertyDao {

    public static void insert(String name, String description, String road, String district, String city, String zip, String country, String phone, String email, String checkIn, String checkOut){
        try{
            Property objProperty = new Property();
            objProperty.setName(name);
            objProperty.setDescription(description);
            objProperty.setRoad(road);
            objProperty.setDistrict(district);
            objProperty.setCity(city);
            objProperty.setZipCode(zip);
            objProperty.setCountry(country);
            objProperty.setPhone(phone);
            objProperty.setEmail(email);
            objProperty.setCheckInTime(checkIn);
            objProperty.setCheckOutTime(checkOut);

            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(Property.class);
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(objProperty);
            System.out.println("Property Created Successfully!");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
