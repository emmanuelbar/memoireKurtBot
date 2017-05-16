package fr.crampi.memoirekurt.dao;

import fr.crampi.memoirekurt.hibernate.HibernateUtil;
import fr.crampi.memoirekurt.modele.Tweet;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created on 23/04/17.
 */
public class TweetDao extends AbstractDao<Tweet> {
    public TweetDao(Session session) {
        super(session, "Tweet");
    }


    @Override
    /**
     * don't care for now
     */
    public Tweet find(long id) {
        return null;
    }

    @Override
    /**
     * Add tweet id so we don't reply 2 times to the same tweet
     */
    public void create(Tweet obj) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println("Saving " + obj.toString());
            session.save(obj);
            tx.commit();
            session.close();
        }
        System.out.println(obj.getId() + " added to DB");
    }
}
