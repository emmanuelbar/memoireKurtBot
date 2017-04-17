package fr.crampi.memoirekurt.twit;

import fr.crampi.memoirekurt.dao.ConvictionDao;
import fr.crampi.memoirekurt.dao.MediaDao;
import fr.crampi.memoirekurt.dao.PoliticDao;
import fr.crampi.memoirekurt.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by crampi on 08/04/17.
 */
public class Remember {

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
            //retrieve convictions in db
            ConvictionDao convictionDao = new ConvictionDao(session);
            session.flush();
			tx.commit();
            // TODO: 13/04/17  search for tweets about politics in major media
            TwitterUtil.searchTweets(politicDao.getPolitics(), mediaDao.getMedias(), convictionDao.getConvictions());
            // // TODO: 13/04/17   reply to said tweets

		} finally {
			session.close();
		}
	}
}


