package net.codejava.model1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserTest {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		        .configure() // configures settings from hibernate.cfg.xml
		        .build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
		    StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category c = new Category();
		c.setName("dongho");
		c.setNameVn("đồng hồ");
		session.save(c);
		session.getTransaction().commit();
	    session.close();
	    sessionFactory.close();
	    System.out.println("dấdaddada");
	    
	}
	
}
