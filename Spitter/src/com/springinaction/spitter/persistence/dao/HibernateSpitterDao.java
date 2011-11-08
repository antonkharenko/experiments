package com.springinaction.spitter.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springinaction.spitter.persistence.Spitter;

@Repository("spitterDao")
public class HibernateSpitterDao implements SpitterDao {
	
	private static final String HQL_SELECT_SPITTER_BY_NAME = "from Spitter where username = :username";
	
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterDao(SessionFactory sessionFactory) {
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
	public Spitter getSpitterByName(String username) {
		Query query = currentSession().createQuery(HQL_SELECT_SPITTER_BY_NAME).setParameter("username", username);
		return HibernateUtils.uniqueResultAndCast(query);
	}
}