package fr.crampi.memoirekurt.twit;

import fr.crampi.memoirekurt.dao.MediaDao;
import fr.crampi.memoirekurt.dao.PoliticDao;
import fr.crampi.memoirekurt.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import twitter4j.*;

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
			session.flush();
			tx.commit();
            // TODO: 13/04/17  search for tweets about politics in major media
            searchTweets();
            // // TODO: 13/04/17   reply to said tweets
            replyToTweets();

		} finally {
			session.close();
		}
	}

    public void searchTweets() {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("test twitter");
        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        for (Status status : result != null ? result.getTweets() : null) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    public void replyToTweets() {
    }
}


