package com.sistema.ees14.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory; //= buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	public static Session buildSessionFactory(){
		try{
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder teste=new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			sessionFactory=config.buildSessionFactory(teste.build());
			return sessionFactory.openSession();
			//serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			//System.out.println("conectado...");
			//return config.buildSessionFactory(serviceRegistry);
		} catch (Throwable e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}