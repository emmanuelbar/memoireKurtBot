package fr.crampi.memoirekurt.dao;

import fr.crampi.memoirekurt.modele.Media;
import org.hibernate.Session;

import java.util.List;

public class MediaDao extends AbstractDao<Media> {

	private List<Media> medias;

	public MediaDao(Session session) {
		super(session, "Media");
	}

	public List<Media> getMedias() {
		return super.getList();
	}

    @Override
    public Media find(long id) {
        return null;
    }

    @Override
    public void create(Media obj) {

    }
}
