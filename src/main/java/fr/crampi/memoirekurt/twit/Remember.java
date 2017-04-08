package fr.crampi.memoirekurt.twit;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.crampi.memoirekurt.dao.PoliticDao;
import fr.crampi.memoirekurt.hibernate.HibernateUtil;
import fr.crampi.memoirekurt.modele.Politic;

/**
 * Created by crampi on 08/04/17.
 */
public class Remember {
	private List<Politic> politics;

	public void start() throws Exception {
		// //init db
		final Session session = HibernateUtil.initHibernate(Politic.class);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			PoliticDao politicDao = new PoliticDao();
			// retrieve politics in db
			politics = politicDao.fetchPolitics(session);
			session.flush();
			tx.commit();
		} finally {
			session.close();
		}
	}
}
// search for tweets about politics in major media

// reply to said tweets
