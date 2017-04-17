package fr.crampi.memoirekurt.dao;

import fr.crampi.memoirekurt.modele.Conviction;
import fr.crampi.memoirekurt.modele.Politic;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by crampi on 17/04/17.
 */
public class ConvictionDao extends AbstractDao<Conviction> {
    private List<Conviction> convictions;

    public ConvictionDao(Session session) {
        super(session, "Conviction");
    }

    public List<Conviction> getConvictions() {
        return super.getList();
    }

    public Conviction getConvictionByPolitic(Politic politic) {
        Conviction conviction = (Conviction) session.get(Conviction.class, politic.getId());
        System.out.println("conviction: " + conviction.getLibelle());
        return null;
    }
}
