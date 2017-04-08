package fr.crampi.memoirekurt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.crampi.memoirekurt.modele.Politic;

/**
 * Created by crampi on 08/04/17.
 */
public class PoliticDao {
	private List<Politic> politics;

	@SuppressWarnings("unchecked")
	public List<Politic> fetchPolitics(Session session) {
		politics = new ArrayList<Politic>();
		politics = session.createQuery("from Politic").list();
		for (Politic politic : politics) {
			System.out.println(politic);
		}
		return politics;
	}
}
