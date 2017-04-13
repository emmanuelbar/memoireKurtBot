package fr.crampi.memoirekurt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public abstract class AbstractDao<E> {
	protected Session session;
	protected List<E> list;

	public AbstractDao(Session session, String classe) {
		super();
		this.session = session;
		this.list = list(classe);
		for (E e : list) {
			System.out.println(e.toString());
		}
	}

	public AbstractDao() {
	}

	/**
	 * Return all the table
	 * 
	 * @param classe
	 * @return
	 */
	protected List<E> list(String classe) {
		list = new ArrayList<E>();
		list = session.createQuery("from " + classe).list();
		return list;
	}

	public List<E> getList() {
		return list;
	}
}
