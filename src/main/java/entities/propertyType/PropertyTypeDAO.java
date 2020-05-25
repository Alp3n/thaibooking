package entities.propertyType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class PropertyTypeDAO {

    public static void insert(String name) {
        try {
            PropertyType objPropertyType = new PropertyType();
            objPropertyType.setName(name);

            SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(PropertyType.class);
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(objPropertyType);
            System.out.println("Property Type Created Successfully!");
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
