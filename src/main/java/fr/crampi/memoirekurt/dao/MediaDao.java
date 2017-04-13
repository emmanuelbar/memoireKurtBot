package fr.crampi.memoirekurt.dao;

import java.util.List;

import org.hibernate.Session;

import fr.crampi.memoirekurt.modele.Media;

public class MediaDao extends AbstractDao<Media> {

	private List<Media> medias;

	public MediaDao(Session session) {
		super(session, "Media");
	}

	public List<Media> getMedias() {
		return super.getList();
	}
}
