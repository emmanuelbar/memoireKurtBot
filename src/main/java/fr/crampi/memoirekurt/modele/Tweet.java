package fr.crampi.memoirekurt.modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by crampi on 23/04/17.
 */
@Entity
@Table(name = "tweet")
public class Tweet {
    @Id
    private long id;

    public Tweet() {

    }

    public Tweet(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + id +
                '}';
    }
}
