package fr.crampi.memoirekurt.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static <T> Session initHibernate(Class<T> classe) {
		Configuration config = new Configuration();
		config.configure();
		config.addClass(classe);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
}
