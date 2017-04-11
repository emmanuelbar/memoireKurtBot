package fr.crampi.memoirekurt.dao;

import java.util.List;

import org.hibernate.Session;

import fr.crampi.memoirekurt.modele.Politic;

/**
 * Created by crampi on 08/04/17.
 * 
 * @param <E>
 */
public class PoliticDao extends AbstractDao<Politic> {
	private List<Politic> politics;

	public PoliticDao(Session session) {
		super(session, "Politic");
	}

	public List<Politic> getPolitics() {
		return super.getList();
	}
}
