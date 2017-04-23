package fr.crampi.memoirekurt.twit;

import fr.crampi.memoirekurt.dao.TweetDao;
import fr.crampi.memoirekurt.hibernate.HibernateUtil;
import fr.crampi.memoirekurt.modele.Conviction;
import fr.crampi.memoirekurt.modele.Media;
import fr.crampi.memoirekurt.modele.Politic;
import fr.crampi.memoirekurt.modele.Tweet;
import org.hibernate.Session;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crampi on 16/04/17.
 */
public class TwitterUtil {
    private static final Twitter twitter = TwitterFactory.getSingleton();

    public static void searchTweets(List<Politic> politics, List<Media> medias, List<Conviction> convictions) {
        for (Politic politic : politics) {
            System.out.println("Search for tweets about " + politic);
            for (Media media : medias) {
                System.out.println("Search on twitter account: " + media.getTwitterAccount());
                try {
                    List<Status> statuses = twitter.getUserTimeline(media.getTwitterAccount());
                    for (Status status : statuses) {
                        if (status.getText().contains(politic.getLastName())) {
                            // tweet found about the politic now we need to reply to said tweet
                            replyToTweet(status, politic);
                        }
                    }
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void replyToTweet(Status status, Politic politic) {
        System.out.println("Replying to tweet id: " + status.getId());
        //get conviction
        List<Conviction> convictions = new ArrayList<>();
        convictions.addAll(politic.getConvictions());
        if (!hasBeenReplied(status)) {
            //reply with @user
            String reply = ".@" + status.getUser().getScreenName() + ": pour rappel " + politic.getLastName() + "a été condamné -> " + convictions.get(0).getLibelle();
            System.out.println("Reply : " + reply);
            StatusUpdate statusUpdate = new StatusUpdate(reply);
            statusUpdate.inReplyToStatusId(status.getId());
            try {
                twitter.updateStatus(statusUpdate);

            } catch (TwitterException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Already responded to id " + status.getId());
        }

    }


    public static boolean hasBeenReplied(Status status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Tweet tweet = session.get(Tweet.class, status.getId());
        if (tweet != null) {
            System.out.println("The tweet id " + status.getId() + " has been replied to.");
            return true;
        } else {
            TweetDao tweetDao = new TweetDao(session);
            tweetDao.create(new Tweet(status.getId()));
            return false;
        }
    }
}
