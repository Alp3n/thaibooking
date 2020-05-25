package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory(Class klass) {
        if (sessionFactory == null) {
            return new Configuration()
                    .configure()
                    .addAnnotatedClass(klass)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}

