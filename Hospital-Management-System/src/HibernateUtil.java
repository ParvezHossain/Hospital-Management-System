/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Parvez
 */
public class HibernateUtil 
{
	    private static SessionFactory sessionFactory;
	    private static ServiceRegistry serviceRegistry;

	    private static SessionFactory configureSessionFactory() throws HibernateException 
	    {
	    	Configuration configuration = new Configuration().configure();
	    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
	    	applySettings(configuration.getProperties());
	    	sessionFactory = configuration.buildSessionFactory(builder.build()); 

	    	return sessionFactory;
	    }


	    public static SessionFactory getSessionFactory() {
	        return configureSessionFactory();

	    }
}

