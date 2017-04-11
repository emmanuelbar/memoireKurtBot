package fr.crampi.memoirekurt.twit;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.crampi.memoirekurt.dao.MediaDao;
import fr.crampi.memoirekurt.dao.PoliticDao;
import fr.crampi.memoirekurt.hibernate.HibernateUtil;
import fr.crampi.memoirekurt.modele.Media;
import fr.crampi.memoirekurt.modele.Politic;

/**
 * Created by crampi on 08/04/17.
 */
public class Remember {
	private List<Politic> politics;
	private List<Media> medias;

	public void start() throws Exception {
		// //init db
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();

		} catch (org.hibernate.HibernateException he) {
			session = HibernateUtil.getSessionFactory().openSession();
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// retrieve politics in db
			PoliticDao politicDao = new PoliticDao(session);
			// retrieve media in db
			MediaDao mediaDao = new MediaDao(session);
			session.flush();
			tx.commit();
		} finally {
			session.close();
		}
	}
}
// search for tweets about politics in major media

// reply to said tweets
