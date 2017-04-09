package fr.crampi.memoirekurt.dao;

import java.util.ArrayList;
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

	public PoliticDao(Session s) {
		politics = list(s);
		for (Politic politic : politics) {
			System.out.println(politic.toString());
		}
	}

	@Override
	public List<Politic> list(Session session) {
		politics = new ArrayList<Politic>();
		politics = session.createQuery("from Politic").list();
		return politics;
	}
}
