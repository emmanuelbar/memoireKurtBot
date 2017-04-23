package fr.crampi.memoirekurt.dao;

import fr.crampi.memoirekurt.modele.Politic;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by crampi on 08/04/17.
 *
 */
public class PoliticDao extends AbstractDao<Politic> {
	private List<Politic> politics;

	public PoliticDao(Session session) {
		super(session, "Politic");
	}

	public List<Politic> getPolitics() {
		return super.getList();
	}

    @Override
    public Politic find(long id) {
        return null;
    }

    @Override
    public void create(Politic obj) {

    }
}
