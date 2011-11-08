package com.springinaction.spitter.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springinaction.spitter.persistence.Spitter;
import com.springinaction.spitter.persistence.Spittle;

@Repository("spittleDao")
public class HibernateSpittleDao implements SpittleDao {
	
	private static final String HQL_SELECT_RECENT_SPITTLES = "from Spittle s order by s.when desc";
	private static final String HQL_SELECT_SPITTLES_FOR_SPITTER = "from Spittle spittle left join fetch spittle.spitter where spittle.spitter.username = :username order by spittle.when desc";
	
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpittleDao(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	public void saveSpitter(Spitter spitter) {
		currentSession().saveOrUpdate(spitter);
	}

	@Override
	public List<Spittle> getSpittlesForSpitter(String username) {
		Query query = currentSession().createQuery(HQL_SELECT_SPITTLES_FOR_SPITTER).setParameter("username", username);
		return HibernateUtils.listAndCast(query);
	}

	@Override
	public List<Spittle> getRecentSpittles(int maxCount) {
		Query query = currentSession().createQuery(HQL_SELECT_RECENT_SPITTLES).setMaxResults(maxCount);
		return HibernateUtils.listAndCast(query);
	}

	@Override
	public void saveSpittle(Spittle spittle) {
		currentSession().save(spittle);
	}
}
