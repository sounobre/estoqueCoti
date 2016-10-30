package persistence;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {    
    private static final SessionFactory sessionFactory = buildSessionFactory();    
    private static SessionFactory buildSessionFactory() {
        try {           
            Configuration configuration = new Configuration().configure("/config/hibernate.cfg.xml");     
            return configuration.buildSessionFactory( new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() ).build() );
        }
        catch (Throwable ex) {                
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }   
}